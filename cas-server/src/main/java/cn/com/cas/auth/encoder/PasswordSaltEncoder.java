package cn.com.cas.auth.encoder;
/**
 * 密码盐值加密
 * @author Boss
 *
 */
public interface PasswordSaltEncoder {
	/**
	 * 密码加密
	 * @param password 密码明文
	 * @param salt 盐值
	 * @return
	 */
   public String encode(String password,String salt);
}
