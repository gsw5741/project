package cn.com.component.auth2.security.realm;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import cn.com.component.auth2.security.token.OAuth2Token;

public class OAuth2Realm extends AuthorizingRealm {
	private String accessTokenUrl;// 认证地址
	private String userInfoUrl;// 资源地址
	private String redirectUrl;// 302重定向地址

	@Override
	public boolean supports(AuthenticationToken token) {
		// 支持OAuth2Token
		return token instanceof OAuth2Token;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		OAuth2Token oauthToken = (OAuth2Token) token;
		String oauthCode = oauthToken.getAuthCode();
		OAuthClient client = new OAuthClient(new URLConnectionClient());
		Session session = SecurityUtils.getSubject().getSession();
		try {
			OAuthClientRequest oauthRequest = OAuthClientRequest.tokenLocation(accessTokenUrl).setCode(oauthCode)
					.setRedirectURI(redirectUrl).setGrantType(GrantType.AUTHORIZATION_CODE)
					.setClientId(session.getId().toString()).setScope(OAuth.OAUTH_SCOPE).buildQueryMessage();
			OAuthAccessTokenResponse oauthResponse = client.accessToken(oauthRequest,OAuth.HttpMethod.POST);
			//授权令牌
			String accessToken = oauthResponse.getAccessToken();
			
		} catch (OAuthSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	public void setUserInfoUrl(String userInfoUrl) {
		this.userInfoUrl = userInfoUrl;
	}

}
