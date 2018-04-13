package cn.com.component.auth2.security.token;

import org.apache.shiro.authc.UsernamePasswordToken;
/**
 * 根据OAuth2认证协议建立认证主体
 * @author Boss
 *
 */
public class OAuth2Token extends UsernamePasswordToken{
	private static final long serialVersionUID = 1L;
	
	private String authCode;//认证授权码


	public OAuth2Token(String authCode){
		this.authCode = authCode;
	}
	
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

}
