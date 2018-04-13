package cn.com.component.shiro.auth.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.ShiroException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.message.ResMsg;
import cn.com.common.util.ConvertUtil;
import cn.com.common.util.RequestUtil;
import cn.com.common.util.StringUtil;

/**
 * 自定义身份认证
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	private String sessionOutUrl;
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	if(StringUtil.isEmpty(sessionOutUrl)){
    		throw new ShiroException("param 'sessionOutUrl' cannot be null");
    	}
       
    	HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setCharacterEncoding("UTF-8");
        //登录超时
        if (RequestUtil.isAjaxQuery(req)) {
            res.getWriter().write(ConvertUtil.toJsonString(new ResultVO<Boolean>(ResMsg.SESSION_TIME_OUT_EXCEPTION.getErrorCode(), ResMsg.SESSION_TIME_OUT_EXCEPTION.getErrorMsg())));
        } else {
            HttpSession session = req.getSession();
            if(session.isNew()){
            	WebUtils.issueRedirect(request, response, sessionOutUrl);
            	return false;
            }
            return super.onAccessDenied(request, response);
        }
        return false;
    }
	public void setSessionOutUrl(String sessionOutUrl) {
		this.sessionOutUrl = sessionOutUrl;
	}
    
}
