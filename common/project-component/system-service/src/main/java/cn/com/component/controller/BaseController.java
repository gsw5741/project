package cn.com.component.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.cn.com.common.vo.ResultVO;
import cn.com.common.message.ResMsg;
import cn.com.common.propertyEditor.DateConvertEditor;
import cn.com.common.propertyEditor.HtmlEscapeEditor;
import cn.com.component.user.cm.bean.business.BSystemUserBean;


public class BaseController {

	/**
	 * 转换时间，以及字符串
	 * @param binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder){
		//转换字符串，对字符串进行HTML编码，防止XSS攻击
    	binder.registerCustomEditor(Date.class,new DateConvertEditor());
    	binder.registerCustomEditor(String.class, new HtmlEscapeEditor());
    }
	protected <T> ResultVO<T> toErrorResult(ResMsg code) {
		return new ResultVO<T>(code.getErrorCode(), code.getErrorMsg());
	}

	protected <T> ResultVO<T> toSucccess() {
		return new ResultVO<T>(true);
	}
   
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttriute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return requestAttriute.getRequest();
	}

	protected BSystemUserBean getCurrentUser() {
		HttpSession session = getSession();
		return (BSystemUserBean) session.getAttribute("currentUser");
	}
	protected String getCurrentLoginName(){
		return getCurrentUser().getLoginName();
	}
	
	protected String getCurrentUserId(){
		return getCurrentUser().getUserId();
	}
	
	
}