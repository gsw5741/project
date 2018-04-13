package cn.com.cas.auth.principal;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.authentication.principal.AbstractWebApplicationService;
import org.jasig.cas.authentication.principal.Response;
import org.jasig.cas.authentication.principal.Response.ResponseType;

import cn.cn.com.common.vo.ResultVO;
import cn.com.cas.auth.context.SpringContextUtil;
import cn.com.common.util.StringUtil;
import cn.com.component.system.redis.cache.RedisCache;
import cn.com.component.system.redis.service.RedisCacheService;
public final class CustomWebApplicationServiceImpl extends AbstractWebApplicationService{
	private static final long serialVersionUID = 1L;

	private static final String CONST_PARAM_SERVICE = "service";
    
	private static final String CONST_PARAM_TICKET = "ticket";
	
	private static final String CONST_PARAM_USER = "user";
    private final ResponseType responseType = ResponseType.REDIRECT;
    
    public CustomWebApplicationServiceImpl(String id){
    	super(id, null, null);
    }
	
	private CustomWebApplicationServiceImpl(String id, String originalUrl, String artifactId) {
		super(id, originalUrl, artifactId);
	}
	
    @SuppressWarnings("unchecked")
	public static CustomWebApplicationServiceImpl createWebApplicationService(HttpServletRequest request){
    	String service = "";
    	RedisCacheService<String> redisCacheService = (RedisCacheService<String>) SpringContextUtil.getBean("redisCacheService");
    	ResultVO<RedisCache<String>> resService = redisCacheService.getRedisCache(CONST_PARAM_SERVICE);
        if(resService.isOk()){
        	service = resService.getObj().getValue();
        }
        if(StringUtil.isEmpty(service)){
        	return null;
        }
        String id = cleanupUrl(service);
        String ticket = request.getParameter(CONST_PARAM_TICKET);
        return new CustomWebApplicationServiceImpl(id,service,ticket);
    	
    }
	@Override
	public Response getResponse(String ticketId) {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(CONST_PARAM_USER, ticketId);
        if (ResponseType.POST == this.responseType) {
            return Response.getPostResponse(getOriginalUrl(), parameters);
        }
        return Response.getRedirectResponse(getOriginalUrl(), parameters);
	}
	
	

}
