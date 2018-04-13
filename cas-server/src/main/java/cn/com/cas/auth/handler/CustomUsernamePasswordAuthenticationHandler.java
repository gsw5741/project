package cn.com.cas.auth.handler;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;

import org.jasig.cas.authentication.AccountDisabledException;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import cn.cn.com.common.vo.ResultVO;
import cn.com.cas.auth.credential.CustomAuthCredential;
import cn.com.cas.auth.encoder.PasswordSaltEncoder;
import cn.com.common.util.StringUtil;
import cn.com.component.service.cm.bean.SysLoginLog;
import cn.com.component.system.cm.service.SysLoginLogService;
import cn.com.component.user.cm.bean.business.BSystemUserBean;
import cn.com.componnet.user.cm.service.SystemUserService;

public class CustomUsernamePasswordAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
	@Autowired
	private PasswordSaltEncoder passswordSaltEncoder;

	@Autowired
	private SystemUserService systemUserService;
	@Autowired
	private SysLoginLogService logService;
	@Override
	protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential)
			throws GeneralSecurityException, PreventedException {
		CustomAuthCredential authCredential = (CustomAuthCredential) credential;
		String password = authCredential.getPassword();
		String username = authCredential.getUsername();
		Map<String,Object> param = authCredential.getCredentialParam();
		ResultVO<BSystemUserBean> res = systemUserService.getUserByName(username);
		if (res.isOk()) {
			BSystemUserBean user = res.getObj();
			String encodePass = passswordSaltEncoder.encode(password, user.getSalt());
			// 密码不匹配
			if (!encodePass.equals(user.getLoginPwd())) {
				throw new AccountNotFoundException("password match error:" + authCredential);
			}
			if(StringUtil.isNotEmptyList(user.getRoleListIds())){
				param.put("defaultRoles",StringUtil.join(user.getRoleListIds(), ","));
			}
		    List<String> menuAuthList = Lists.newArrayList(user.getMenuAuthSet());
			param.put("defaultPermissions",StringUtil.join(menuAuthList, ","));
		} else {
			throw new AccountDisabledException("account not find:" + username);
		}
		SysLoginLog log = new SysLoginLog();
		log.setLoginIp(param.get("loginIp").toString());
		log.setLoginUserName(username);
		ResultVO<SysLoginLog> reso = logService.addLoginLog(log);
		if(reso.isOk()){
			log = reso.getObj();
			param.put("userLoginId", log.getLoginId());
		}
		
		return createHandlerResult(authCredential, new SimplePrincipal(username,param), null);
	}

}
