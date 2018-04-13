package cn.com.common.util;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;


/**
 * Md5加密工具类 .
 * 
 * @author liuqing 
 * @date 2014-10-11
 */
public class Md5Util {
	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	'A', 'B', 'C', 'D', 'E', 'F' };
	// 盐值码
	public static final String SALTHEXSTRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final Random RANDOM=new Random(System.currentTimeMillis());
	/**
	 * 生成指定长度的盐值.
	 * 
	 * @return
	 */
	public static String generateSalt(int length){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int index=RANDOM.nextInt(SALTHEXSTRING.length());
			sb.append(SALTHEXSTRING.charAt(index));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		String sault=generateSalt(6);
		String pwd=md5WithSalt("000000", "8HGaeS");
		System.out.println(sault);
		System.out.println(pwd);
	}
	/**
	 * 用盐值md5加密字符串.
	 * 
	 * @param text 原字符串
	 * @param salt 盐值
	 * @return
	 */
	public static String md5WithSalt(String text, String salt) {
		String md5str = md5(text);
		String saltStr = md5(salt).substring(8, 32);
		String result = Base64.encode(hexchar2bin(md5str, saltStr));
		return result;
	}

	/**
	 * 数组转16进制字符串.
	 * 
	 * @param b 待转为字符串的数组
	 * @return
	 */
	public static String toHexString(byte[] b) {

		// String to byte

		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}
	/**
	 * 以盐值为种子，混淆md5str字符串.
	 * @param md5str
	 * @param salt
	 * @return
	 */
	private static byte[] hexchar2bin(String md5str, String salt) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(md5str.length() / 2);
		for (int i = 0; i < md5str.length(); i = i + 2) {
			baos.write((salt.indexOf(md5str.charAt(i)) << 4 | salt.indexOf(md5str.charAt(i + 1))<<2));
		}
		return baos.toByteArray();
	}
	/**
	 * md5方式加密字符串，并将加密后的数组转成16进制字符串.
	 * 
	 * @param s 待加密的字符串
	 * @return
	 */
	public static String md5(String s) {

		try {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");

			digest.update(s.getBytes());

			byte messageDigest[] = digest.digest();

			return toHexString(messageDigest);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		return "";
	}
}
