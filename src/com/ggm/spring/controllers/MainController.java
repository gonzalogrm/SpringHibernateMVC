package com.ggm.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//${pageContext.request.contextPath}
//Para evitar conflictos con otras rutas.
//Las rutas de los métodos son relativas a esta.
@RequestMapping()
public class MainController {	
	@RequestMapping()
	public String index(){
		return "index";
	}
	
	@RequestMapping("/index")
	public String goToIndex(){
		return "index";
	}	
}
