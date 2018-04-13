package cn.com.component.shiro.cas.filter;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.message.ResMsg;
import cn.com.common.util.ConvertUtil;
import cn.com.common.util.RequestUtil;
/**
 * 自定义权限认证过滤器
 *
 */
public abstract class CustomCasAuthFilter extends CasFilter {
	
    private static final String DEFAULT_REMEMBER_ME_PARAM = "rememberMe";

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        PrintWriter out = res.getWriter();
        //登录超时
        if (RequestUtil.isAjaxQuery(req)) {
        	if(!validateTicket(request, response)){
        		out.write(ConvertUtil.toJsonString(new ResultVO<Boolean>(ResMsg.CAS_TICKET_EXCEPTION.getErrorCode(), ResMsg.CAS_TICKET_EXCEPTION.getErrorMsg())));
        	}else{
        	    out.write(ConvertUtil.toJsonString(new ResultVO<Boolean>(ResMsg.SESSION_TIME_OUT_EXCEPTION.getErrorCode(), ResMsg.SESSION_TIME_OUT_EXCEPTION.getErrorMsg())));
        	}
           out.flush();
        } else {
            return super.onAccessDenied(request, response);
        }
        return false;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		return validateTicket(request,response) && subject.isAuthenticated();
	}

	@Override
	protected boolean isRememberMe(ServletRequest request) {
		return WebUtils.isTrue(request, DEFAULT_REMEMBER_ME_PARAM);
	}
	/**
	 * 验证ticket票据是否有效
	 * @return
	 */
	protected abstract boolean validateTicket(ServletRequest request,ServletResponse response);
	/**
	 * 构建验证ticket票据地址
	 * @param request
	 * @param response
	 * @return
	 */
    protected abstract String constructServiceUrl(HttpServletRequest request,HttpServletResponse response);
}
