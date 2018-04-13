package cn.com.cas.auth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.jasig.cas.logout.LogoutRequest;
import org.jasig.cas.logout.LogoutRequestStatus;
import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.ServicesManager;
import org.jasig.cas.web.flow.AbstractLogoutAction;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import cn.cn.com.common.vo.ResultVO;
import cn.com.cas.auth.principal.CustomWebApplicationServiceImpl;
import cn.com.component.system.redis.cache.RedisCache;
import cn.com.component.system.redis.service.RedisCacheService;

public class CustomLogoutAction extends AbstractLogoutAction {

    @NotNull
    private ServicesManager servicesManager;
    
    private boolean followServiceRedirects;
    
    @NotNull
    private RedisCacheService<String> redisCacheService;
    
    private static final String CONST_PARAM_SERVICE = "logoutUrl";

    @Override
    protected Event doInternalExecute(final HttpServletRequest request, final HttpServletResponse response,
            final RequestContext context) throws Exception {

        boolean needFrontSlo = false;
        putLogoutIndex(context, 0);
        final List<LogoutRequest> logoutRequests = WebUtils.getLogoutRequests(context);
        if (logoutRequests != null) {
            for (LogoutRequest logoutRequest : logoutRequests) {
                // if some logout request must still be attempted
                if (logoutRequest.getStatus() == LogoutRequestStatus.NOT_ATTEMPTED) {
                    needFrontSlo = true;
                    break;
                }
            }
        }
        ResultVO<RedisCache<String>> res = redisCacheService.getRedisCache(CONST_PARAM_SERVICE);
        String service = null;
        if(res.isOk()){
        	service = res.getObj().getValue();
        }
        if (this.followServiceRedirects && service != null) {
            final RegisteredService rService = this.servicesManager.findServiceBy(new CustomWebApplicationServiceImpl(service));

            if (rService != null && rService.isEnabled()) {
                context.getFlowScope().put("logoutRedirectUrl", service);
            }
        }

        if (needFrontSlo) {
            return new Event(this, FRONT_EVENT);
        } else {
            // otherwise, finish the logout process
            return new Event(this, FINISH_EVENT);
        }
    }

    public void setFollowServiceRedirects(final boolean followServiceRedirects) {
        this.followServiceRedirects = followServiceRedirects;
    }

    public void setServicesManager(final ServicesManager servicesManager) {
        this.servicesManager = servicesManager;
    }

	public void setRedisCacheService(RedisCacheService<String> redisCacheService) {
		this.redisCacheService = redisCacheService;
	}
     
}
