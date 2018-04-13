package cn.com.component.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cn.com.common.vo.Page;
import cn.cn.com.common.vo.PageVO;
import cn.cn.com.common.vo.ResultVO;
import cn.com.common.util.StringUtil;
import cn.com.component.controller.BaseController;
import cn.com.component.user.cm.bean.SystemUser;
import cn.com.component.user.cm.bean.business.BSystemUserBean;
import cn.com.componnet.user.cm.service.SystemUserService;


/**
 * 系统用户控制层
 *
 */
@Controller
@RequestMapping("/sysUser")
public class SystemUserController extends BaseController {
   @Autowired
   private SystemUserService userService;
   
   /**
    * 用户列表
    * @return
    */
   @RequestMapping("/userList")
   public String userList(){
	   return "system/user/sysUserList";
   }
   /**
    * 用户数据
    * @param pager
    * @param param
    * @return
    */
   @RequestMapping("/userListData")
   public ResultVO<Page<SystemUser>> userListData(Page<SystemUser> pager,SystemUser param){
	   ResultVO<Page<SystemUser>> res = userService.getSystemUserList(new PageVO<SystemUser>(pager,param));
	   return res;
   }
   /**
    * 增加修改用户页面
    * @param map
    * @param userId
    * @return
    */
   @RequestMapping("/userAddOrUpdate/{userId}")
   public String userAddOrUpdate(ModelMap map,@PathVariable String userId){
	   BSystemUserBean dataInfo = new BSystemUserBean();
	   if(StringUtil.isNotEmpty(userId)){
		   ResultVO<BSystemUserBean> res = userService.getUserByUserId(userId);
		   if(res.isOk()){
			   dataInfo = res.getObj();
		   }
	   }
	   map.put("dataInfo", dataInfo);
	   return "system/user/userAddOrUpdate";
   }
   /**
    * 增加用户方法
    * @param record
    * @return
    */
   @RequestMapping("/userAddOrUpdateMethod")
   public @ResponseBody ResultVO<?> userAddOrUpdateMethod(BSystemUserBean record){
	   ResultVO<Boolean> res = null;
	   if(StringUtil.isNotEmpty(record.getUserId())){
		   res = userService.updateUser(record);
	   }else{
		   res = userService.addUser(record);
	   }
	   return res;
   }
}
