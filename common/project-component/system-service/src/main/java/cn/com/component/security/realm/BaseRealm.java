package cn.com.component.security.realm;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.google.common.collect.Sets;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.message.ResMsg;
import cn.com.component.service.cm.bean.SystemMenu;
import cn.com.component.shiro.security.matcher.CustomCredentials;
import cn.com.component.user.cm.bean.business.BSystemRoleBean;
import cn.com.component.user.cm.bean.business.BSystemUserBean;
import cn.com.componnet.user.cm.service.SystemUserService;

public class BaseRealm extends  AuthorizingRealm{
	@Autowired
	SystemUserService userService;
    /**
     * 登录认证
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userToken=(UsernamePasswordToken) token;
		String userName= userToken.getUsername();
		Session session =SecurityUtils.getSubject().getSession();
		//SystemUser sysUser=(SystemUser) session.getAttribute("currentUser");
		//session中用户存在直接登录
		/*if(!StringUtils.isEmpty(sysUser)&&sysUser.getLoginName().equals(userName)){
			return new SimpleAuthenticationInfo(sysUser, new CustomCredentials(sysUser.getLoginPwd(), sysUser.getSalt()), getName());
		}*/
		ResultVO<BSystemUserBean> res=userService.getUserByName(userName);
		if(res.isOk()){
			BSystemUserBean user=res.getObj();
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, new CustomCredentials(user.getLoginPwd(), user.getSalt()), getName());
	    	session.setAttribute("currentUser", user);
	    	session.setAttribute("menuList", user.getMenuList());
		    return info;
		}else{
			throw new UnknownAccountException(ResMsg.LOGIN_EXCEPTION.getErrorCode());
		}
		
	}
    /**
     * 获取角色与权限
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Session session = SecurityUtils.getSubject().getSession();
		//查看保存的权限是否存在，存在直接授权
		SimpleAuthorizationInfo saveInfo = (SimpleAuthorizationInfo) session.getAttribute("SIMPLEAUTHORIZATIONINFO");
		if(!StringUtils.isEmpty(saveInfo)){
			return saveInfo;
		}
		SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
		BSystemUserBean sysUser=(BSystemUserBean) principals.getPrimaryPrincipal();
		Set<String> roleSet=Sets.newLinkedHashSet();//角色权限
		Set<String> menuSet=Sets.newLinkedHashSet();//菜单权限
		for(BSystemRoleBean role:sysUser.getRoleList()){
			roleSet.add(role.getRoleName());
			for(SystemMenu menu:role.getMenuList()){
				if(!StringUtils.isEmpty(menu.getMenuAuth())){
					menuSet.add(menu.getMenuAuth());
				}	
			}
		}
		info.addRoles(roleSet);//角色权限
		info.addStringPermissions(menuSet);//菜单权限
		session.setAttribute("SIMPLEAUTHORIZATIONINFO", info);
		return info;
	}

}
