package cn.com.cas.auth.web;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.authentication.principal.WebApplicationService;
import org.jasig.cas.web.support.AbstractArgumentExtractor;

import cn.com.cas.auth.principal.CustomWebApplicationServiceImpl;

public class CustomCasArgumentExtractor extends AbstractArgumentExtractor {

	@Override
	protected WebApplicationService extractServiceInternal(HttpServletRequest request) {
		return CustomWebApplicationServiceImpl.createWebApplicationService(request);
	}

}
