package cn.com.component.cas.security.realm;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.util.StringUtil;
import cn.com.component.system.redis.cache.RedisCache;
import cn.com.component.system.redis.service.RedisCacheService;
import cn.com.component.user.cm.bean.business.BSystemUserBean;
import cn.com.componnet.user.cm.service.SystemUserService;

public class CustomCasRealm extends CasRealm {
	@Autowired
	private SystemUserService userService;

	@Autowired
	private RedisCacheService<String> redisCacheService;

	private static final String CONST_PARAM_SERVICE = "service";

	@Override
	public void setCasService(String casService) {

		super.setCasService(casService);
		RedisCache<String> record = new RedisCache<String>(CONST_PARAM_SERVICE, casService);
		redisCacheService.addRedisCache(record);

	}

   /**
    * 验证凭证
    */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (StringUtil.isEmpty(casToken.getPrincipal())) {
			throw new CasAuthenticationException("missing principal");
		}
		String username = casToken.getPrincipal().toString();
		if (StringUtil.isEmpty(username)) {
			throw new CasAuthenticationException("missing principal");
		}
		casToken = reloadCasToken(casToken, username);
		AuthenticationInfo info = super.doGetAuthenticationInfo(casToken);
		if (StringUtil.isNotEmpty(info)) {
			ResultVO<BSystemUserBean> res = userService.getUserByName(username);
			if (res.isOk()) {
				BSystemUserBean user = res.getObj();
				Session session = SecurityUtils.getSubject().getSession();
				session.setAttribute("currentUser", user);
				session.setAttribute("menuList", user.getMenuList());
			}

		}
		return info;

	}

	private CasToken reloadCasToken(CasToken casToken, String username) {
		ResultVO<RedisCache<String>> loginRes = redisCacheService.getRedisCache(username);
		String loginId = "";
		if (loginRes.isOk()) {
			loginId = loginRes.getObj().getValue();
			if (StringUtil.isEmpty(loginId)) {
				throw new CasAuthenticationException("login time out,loginId is null");
			}
			loginRes = redisCacheService.getRedisCache(loginId);
			if (loginRes.isOk()) {
				String ticket = loginRes.getObj().getValue();
				if (StringUtil.isEmpty(ticket)) {
					throw new CasAuthenticationException("missing ticket");
				}
				casToken = new CasToken(ticket);
				casToken.setUserId(username);
			}
		}
		return casToken;
	}

	/**
	 * 凭证匹配
	 */
	@Override
	protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
			throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (StringUtil.isEmpty(casToken.getPrincipal())) {
			throw new CasAuthenticationException("missing principal");
		}
		String username = casToken.getPrincipal().toString();
		casToken = reloadCasToken(casToken, username);
		super.assertCredentialsMatch(casToken, info);
	} 
	/**
	 * 获取权限
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
		List<Object> listPrincipals = principalCollection.asList();
		//认证参数
		Map<String, String> attributes = (Map<String, String>) listPrincipals.get(1);
		String defaultRoles = attributes.get("defaultRoles");
		if(StringUtil.isNotEmpty(defaultRoles)){
			setDefaultRoles(defaultRoles);
		}
		String defaultPermissions = attributes.get("defaultPermissions");
		if(StringUtil.isNotEmpty(defaultPermissions)){
			setDefaultPermissions(defaultPermissions);
		}
		return super.doGetAuthorizationInfo(principalCollection);
	}
	

}
