package cn.com.common.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CgLibUtil implements MethodInterceptor {
	private final String s;
	public CgLibUtil(){
		s = "aa";
	}
	private Object targetObject;

	public Object createProxy(Object obj) {
		this.targetObject = obj;
		Enhancer hancer = new Enhancer();
		hancer.setCallback(this);
		hancer.setSuperclass(obj.getClass());
		return hancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if(method.getName().equals("addUser")){
			System.out.println("调用代理");
		}
		

		return method.invoke(targetObject, args);
	}
	public static void main(String[] args) {
		UserService user = (UserService) new CgLibUtil().createProxy(new UserServiceImpl());
	    user.addUser("11");
	}
}
