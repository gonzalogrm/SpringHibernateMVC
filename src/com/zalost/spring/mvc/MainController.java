package com.zalost.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/goToForm")
	public String pageForm(){
		return "pageFormView";
	}
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "processFormView";
	}
	
	@RequestMapping("/preprocessForm")
	public String preprocessForm(HttpServletRequest request, Model model){
		//Modificamos el valor introducido por el usuario
		String value = (String)request.getParameter("nombre");
		value += "_preprocessed";
		
		//Modificamos el modelo
		model.addAttribute("preprocessedName", value);
		
		//Redirect
		return "processFormView";
	}
	
	
	
}
