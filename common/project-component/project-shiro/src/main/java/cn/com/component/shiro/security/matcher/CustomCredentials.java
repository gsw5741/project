package cn.com.component.shiro.security.matcher;

import java.io.Serializable;

//自定义凭证
public class CustomCredentials implements Serializable {

	private static final long serialVersionUID = 1L;
	// 用户密码
	private String userPwd;
	// 用户盐值
	private String salt;

	public CustomCredentials(String userPwd, String salt) {
		this.salt = salt;
		this.userPwd = userPwd;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
