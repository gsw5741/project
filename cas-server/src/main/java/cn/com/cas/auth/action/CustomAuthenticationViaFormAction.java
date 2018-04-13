package cn.com.cas.auth.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.web.flow.AuthenticationViaFormAction;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.execution.RequestContext;

import cn.com.cas.auth.credential.CustomAuthCredential;
import cn.com.common.util.RequestUtil;

public class CustomAuthenticationViaFormAction extends AuthenticationViaFormAction {
	 public final String checkCredentialParam(final RequestContext context, Credential credentials, final MessageContext messageContext) throws Exception {
		 final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
		 CustomAuthCredential customCredential = (CustomAuthCredential) credentials;
		 String ip =  RequestUtil.getIp(request);
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("loginIp", ip);
		 map.put("loginDev", request.getHeader("User-Agent"));
		 customCredential.setCredentialParam(map);
		 return "success";
	 }
}
