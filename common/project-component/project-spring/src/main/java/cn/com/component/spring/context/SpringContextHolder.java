package cn.com.component.spring.context;

import org.springframework.context.ApplicationContext;

public class SpringContextHolder {
	public static ApplicationContext applicationContext;

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}
}
