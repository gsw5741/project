package cn.com.cas.auth.encoder;

import cn.com.common.util.Md5Util;

public class CustomPasswordEncoder implements PasswordSaltEncoder {

	@Override
	public String encode(String password, String salt) {
		
		return Md5Util.md5WithSalt(password, salt);
	}
    

}
