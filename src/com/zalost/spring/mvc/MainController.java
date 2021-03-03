package com.zalost.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {	
	@RequestMapping
	public String index(){
		return "index";
	}
	
	@RequestMapping("/goToIndex")
	public String goToIndex(){
		return "index";
	}
	
	//Este controlador redirige a views posteriores
	@RequestMapping("/pageForm")
	public String pageForm(){
		return "pageFormView";
	}
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "processFormView";
	}
}
