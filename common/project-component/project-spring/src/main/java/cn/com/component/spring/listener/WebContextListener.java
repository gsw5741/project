package cn.com.component.spring.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.component.spring.context.SpringContextHolder;

/**
 * 上下文监听器
 * @author Boss
 *
 */
public class WebContextListener implements ServletContextListener {
    //监听器初始化
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		   SpringContextHolder.applicationContext=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
 
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		

	}

}
