package cn.com.component.user.controller;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.message.ResMsg;
import cn.com.component.controller.BaseController;
import cn.com.component.spring.properties.SystemConfig;
import cn.com.component.user.cm.bean.SystemUser;
import cn.com.componnet.user.cm.service.SystemUserService;

/**
 * 控制层
 *
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
	@Autowired
    private SystemUserService userService;
	/**
	 * 登录页面
	 */
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(ModelMap map){
		//map.put("authLoginUrl", SystemConfig.getConfig("casServer.address"));
		return "system/login";
	}
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/loginOut")
	public String loginOut(ModelMap map){
		HttpSession session =getSession();
		String username = getCurrentLoginName();
		session.removeAttribute("currentUser");
		//map.put("authLoginUrl", SystemConfig.getConfig("casServer.address"));
		return "redirect:"+SystemConfig.getConfig("logoutUrl")+"?user="+username;
	}
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("/register")
	public String register(){
		return "system/register";
	}
	/**
	 * 登录认证
	 * @param user
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody ResultVO<?> loginAuth(SystemUser user){
		try {
			UsernamePasswordToken userToken = new UsernamePasswordToken(user.getLoginName(),user.getLoginPwd());
			//remember me
	    	if("1".equals(user.getIsRememberme())){
	    		userToken.setRememberMe(true);
	    	}
			SecurityUtils.getSubject().login(userToken);
		
		}catch (UnknownAccountException e) {
			return toErrorResult(ResMsg.LOGIN_EXCEPTION);
			
		}catch(IncorrectCredentialsException e){
			return toErrorResult(ResMsg.LOGIN_EXCEPTION);
		}catch (AccountException e) {
			   return toErrorResult(ResMsg.LOGIN_EXCEPTION);
	    }catch (Exception e) {
			return toErrorResult(ResMsg.COM_EXCEPTION);
		}
		return toSucccess();
	}
	 /**
	    * 检查用户名是否重复
	    * @param loginName
	    * @return
	    */
	   @RequestMapping("/checkLoginName")
	   public @ResponseBody ResultVO<?> checkUser(String loginName){
		   ResultVO<Boolean> res=userService.checkUser(loginName);
		   return res;
	   }
	   /**
	    * 检查邮箱是否重复
	    * @param email
	    * @return
	    */
	   @RequestMapping("/checkEmail")
	   public @ResponseBody ResultVO<?> checkEmail(String email){
		   ResultVO<Boolean> res= userService.checkEmail(email);
		   return res;
	   }
	   /**
		 * 注册用户
		 * @param user
		 * @return
		 */
		@RequestMapping("/registerMethod")
		public @ResponseBody ResultVO<?> register(SystemUser user){
			ResultVO<Boolean> res = userService.addUser(user);
			return res;
		}
		/**
		 * 超时登录
		 * @return
		 */
		@RequestMapping("/sessionOut")
		public String sessionOut(){
			return "system/sessionOut";
		}
}
