package cn.com.common.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	public static String getRequestBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		return basePath;
	}

	/**
	 * 判断是否是ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxQuery(HttpServletRequest request) {
		return ((request.getHeader("accept") != null && request.getHeader(
				"accept").indexOf("application/json") > -1) || (request
				.getHeader("X-Requested-With") != null && request.getHeader(
				"X-Requested-With").indexOf("XMLHttpRequest") > -1));
	}
//	/**
//	 * 获取request
//	 * @return
//	 */
//	public static HttpServletRequest getRequest(){
//		ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		return requestAttributes.getRequest();
//	}
	/**
	 * 获取request IP地址
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    ip = ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	    return ip;
	}

//	/**
//	 * 获取session
//	 * @return
//	 */
//	public static HttpSession getSession(){
//		return getRequest().getSession();
//	}
}
