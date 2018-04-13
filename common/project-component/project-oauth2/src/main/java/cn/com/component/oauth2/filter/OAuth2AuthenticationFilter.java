package cn.com.component.oauth2.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import cn.com.common.util.StringUtil;
import cn.com.component.auth2.security.token.OAuth2Token;

public class OAuth2AuthenticationFilter extends FormAuthenticationFilter {
    private String failureUrl;//失败页面
    
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response){
		String oauthCode = request.getParameter(OAuth.OAUTH_CODE);
		OAuth2Token oauthToken =  new OAuth2Token(oauthCode);
		return oauthToken;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if(StringUtil.isEmpty(failureUrl)){
			throw new ShiroException("param 'failureUrl' cannot be null");
		}
		String error = request.getParameter(OAuthError.OAUTH_ERROR);
		//认证服务端发生错误
	    if(!StringUtil.isEmpty(error)){
	    	//跳转到失败页面
	    	WebUtils.issueRedirect(request, response, failureUrl);
	    	return false;
	    }
	    Subject subject = getSubject(request, response);
	    if(!subject.isAuthenticated()){
	    	String oauthCode = request.getParameter(OAuth.OAUTH_CODE);
	    	//没有授权认证，跳转到授权认证页面
	    	if(StringUtil.isEmpty(oauthCode)){
	    		saveRequestAndRedirectToLogin(request, response);
	    	}
	    	return false;
	    }
	    
		return super.onAccessDenied(request, response);
	}

	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}
    
}
