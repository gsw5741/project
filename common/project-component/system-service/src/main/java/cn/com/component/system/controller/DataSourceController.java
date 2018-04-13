package cn.com.component.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.component.controller.BaseController;
@Controller
@RequestMapping("/dataSource")
public class DataSourceController extends BaseController {
	/**
	 * 数据源监控
	 * @return
	 */
	@RequestMapping("/monitor")
    public String monitor(){
    	return "system/datasource/monitor";
    }
}
