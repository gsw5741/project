package cn.com.component.cas.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.util.Assert;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.log4j.BaseLogger;
import cn.com.common.util.StringUtil;
import cn.com.component.shiro.cas.filter.CustomCasAuthFilter;
import cn.com.component.system.redis.cache.RedisCache;
import cn.com.component.system.redis.service.RedisCacheService;
import cn.com.component.user.cm.bean.business.BSystemUserBean;

/**
 * 验证ticket票据是否有效
 *
 */
public class CustomCaseTicketValidateFilter extends CustomCasAuthFilter {
	private static final String TICKET_PARAMETER = "user";

	private TicketValidator ticketValidator;

	private RedisCacheService<String> redisCacheService;
	
	private String serviceUrl;

	public void setServiceUrl(String serviceUrl) {
		
		this.serviceUrl = serviceUrl;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setTicketValidator(TicketValidator ticketValidator) {
		this.ticketValidator = ticketValidator;
	}

	public void setRedisCacheService(RedisCacheService<String> redisCacheService) {
		this.redisCacheService = redisCacheService;
	}

	/**
	 * 创建token
	 */

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String ticket = httpRequest.getParameter(TICKET_PARAMETER);
		CasToken token = new CasToken(ticket);
		token.setUserId(ticket);
		token.setRememberMe(isRememberMe(request));
		return token;
	}

	/**
	 * 验证ticket票据是否有效
	 */
	@Override
	protected boolean validateTicket(ServletRequest request,ServletResponse response) {
		Assert.notNull(serviceUrl);
		Subject subject = getSubject(request, response);
		if(subject.isAuthenticated()){
			Session session= subject.getSession();
			if(StringUtil.isNotEmpty(session.getAttribute("currentUser"))){
				BSystemUserBean user = (BSystemUserBean) session.getAttribute("currentUser");
				ResultVO<RedisCache<String>> res = redisCacheService.getRedisCache(user.getLoginName());
				if(res.isOk()){
					String loginId = res.getObj().getValue();
					if(StringUtil.isNotEmpty(loginId)){ 
						res = redisCacheService.getRedisCache(loginId);
						if(res.isOk()){
							String ticket = res.getObj().getValue();
							String service = constructServiceUrl((HttpServletRequest)request,(HttpServletResponse)response);
							try {
								Assertion assertion = ticketValidator.validate(ticket, service);
								BaseLogger.info("Successfully authenticated user: " + assertion.getPrincipal().getName());
								return true;
							} catch (TicketValidationException e) {
								BaseLogger.error(e);
							}
						}
					}
				}
			}
			
		}
	    
		
		return false;
	}

	@Override
	protected String constructServiceUrl(HttpServletRequest request, HttpServletResponse response) {
		Assert.notNull(serviceUrl);
		return CommonUtils.constructServiceUrl(request, response, serviceUrl, null, null, true);
	}

}
