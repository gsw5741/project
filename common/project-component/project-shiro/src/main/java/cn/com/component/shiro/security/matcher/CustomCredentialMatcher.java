package cn.com.component.shiro.security.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import cn.com.common.util.Md5Util;

//自定义密码验证器
public class CustomCredentialMatcher implements CredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,AuthenticationInfo info) {
		UsernamePasswordToken userToken=(UsernamePasswordToken) token;
		String password=new String(userToken.getPassword());//输入的密码
		CustomCredentials credentials=(CustomCredentials) info.getCredentials();
		String salt=credentials.getSalt();//保存的盐值
		String resourcePwd=credentials.getUserPwd();//保存的密码
		String encodePwd=Md5Util.md5WithSalt(password, salt);//对输入的密码加密
		//匹配密码
		if(encodePwd.equals(resourcePwd)){
			return true;
		}
		return false;
	}

}
