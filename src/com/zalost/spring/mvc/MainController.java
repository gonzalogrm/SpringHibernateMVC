package com.zalost.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping
	public String muestraPagina(){
		return "helloworld";
	}
}
