package cn.com.component.spring.properties;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 读取配置文件
 * @author Boss
 *
 */
public class SystemConfig {
	 public static Map<Object,Object> propertiesMap = new ConcurrentHashMap<Object,Object>();
     
	 public static Object getConfig(Object key){
		 return propertiesMap.get(key);
	 }

	public static Map<Object, Object> getPropertiesMap() {
		return propertiesMap;
	}
	 
} 
