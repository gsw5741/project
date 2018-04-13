package cn.com.cas.auth.action;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.RequestContext;

import cn.cn.com.common.vo.ResultVO;
import cn.com.cas.auth.credential.CustomAuthCredential;
import cn.com.common.util.StringUtil;
import cn.com.component.system.redis.cache.RedisCache;
import cn.com.component.system.redis.service.RedisCacheService;
/**
 * 存放缓存数据
 *
 */
public class RedisCacheAction{
    private RedisCacheService<String> redisCacheService;
    
    public void setRedisCacheService(RedisCacheService<String> redisCacheService) {
		this.redisCacheService = redisCacheService;
	}

	private static final String TICKET_KEY = "userLoginId";
	
	private static final String CONST_PARAM_USER = "user";
    
	public String saveRedisCache(RequestContext context,Credential credentials) throws Exception {
		CustomAuthCredential credential = (CustomAuthCredential) credentials;
    	HttpServletRequest request = WebUtils.getHttpServletRequest(context);
    	HttpSession session = request.getSession();
    	if(StringUtil.isNotEmpty(credential.getCredentialParam())){
    		Map<String,Object> map = credential.getCredentialParam();
    		if(StringUtil.isNotEmpty(map.get(TICKET_KEY))){
    			String key = map.get(TICKET_KEY).toString();
        		String ticket = WebUtils.getServiceTicketFromRequestScope(context);
        		if(StringUtil.isNotEmpty(ticket)&&StringUtil.isNotEmpty(key)){
        			RedisCache<String> redisCache = new RedisCache<String>(key, ticket,(long)session.getMaxInactiveInterval(),TimeUnit.SECONDS);
        			redisCacheService.addRedisCache(redisCache);
        			redisCache.setKey(credential.getUsername());
        			redisCache.setValue(key);
        			redisCacheService.addRedisCache(redisCache);
        			
        		}
    		}
    		
    	}
    	
		
		return "success";
	}
    public String deleteRedisCache(RequestContext context) throws Exception{
    	HttpServletRequest request = WebUtils.getHttpServletRequest(context);
    	String username = request.getParameter(CONST_PARAM_USER);
    	if(StringUtil.isNotEmpty(username)){
    		ResultVO<RedisCache<String>> res = redisCacheService.getRedisCache(username);
    		if(res.isOk()){
    			String loginId = res.getObj().getValue();
    			redisCacheService.deleteRedisCache(loginId);
    			redisCacheService.deleteRedisCache(username);
    		}
    	}
    	return "success";
    }
}
