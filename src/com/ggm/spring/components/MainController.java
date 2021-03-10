package com.ggm.spring.components;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Para evitar conflictos con otras rutas.
//Las rutas de los métodos son relativas a esta.
//@RequestMapping("/mainController")
public class MainController {	
	@RequestMapping()
	public String index(){
		return "index";
	}
	
	@RequestMapping("/goToIndex")
	public String goToIndex(){
		return "index";
	}	
}
