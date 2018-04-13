package cn.com.component.system.dic;

import java.util.List;

import cn.com.component.service.cm.bean.SystemDict;
import cn.com.component.spring.properties.SystemConfig;
import cn.com.component.system.ehcache.EacheService;

public class DictContext {
    private static EacheService eache = EacheService.getInstance();
    
    public static List<SystemDict> getSystemDictByCode(String code){
    	return eache.getSystemDictList(code);
    }
    
    public static String getSystemDictLabel(String code,String codeValue){
    	return eache.getDictLabel(code, codeValue);
    }
    public static String getSystemConfig(String configKey){
    	return SystemConfig.getConfig(configKey).toString();
    }
}
