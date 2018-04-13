package cn.com.mynetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.component.controller.BaseController;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	@RequestMapping("/index")
     public String index(){
    	 return "system/index";
     }
}
