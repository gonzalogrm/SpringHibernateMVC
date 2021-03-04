package com.zalost.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	//public String preprocessForm(HttpServletRequest request, Model model){
	public String preprocessForm(@RequestParam("nombre") String value, Model model){
		//Modificamos el valor introducido por el usuario
		//String value = (String)request.getParameter("nombre");
		
		//RequestParam permite obtener directamente el valor 
		//buscando por identificador del formulario
		value += "_preprocessed";
		
		//Modificamos el modelo
		model.addAttribute("preprocessedName", value);
		
		//Redirect
		return "processFormView";
	}
	
	
	
}
