package com.ggm.spring.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.ggm.spring.entity.User;
import com.ggm.spring.persistence.DAO;
import com.ggm.spring.persistence.SearchParameters;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private DAO dao;
	
	@InitBinder
	//Método privado para evitar espacios en blanco
	private void stringBinder(WebDataBinder binder) {
		StringTrimmerEditor blankTrimmer = 
			new StringTrimmerEditor(true);
		binder.registerCustomEditor(
			String.class, blankTrimmer);
	}
		
	//------------ Mostrar todos Usuarios ------------//
	@RequestMapping("/userlist")
	public String userList(Model model) {
		//Get from DAO
		List<User> users= 
			dao.selectGenericFromCriteria(
				User.class, "from User");
		
		System.out.println(users.toString());
		
		//Add to model
		model.addAttribute("userList", users);		

		return "userview/userListView";
	}
	
	
	
	//------------ Nuevo Usuario ------------//
	@RequestMapping("/newUserFrom")
	public String newUserForm(Model model) {
		//Testing Spring prototype
		User user = new User();		
		model.addAttribute("user", user);
		
		return "userview/userRegisterForm";
	}
	
	@PostMapping("/processNewUser")
	//@Valid para especificar que tenemos validación
	public String processNewUser(@Valid @ModelAttribute("user") User userToken, 
			BindingResult resValidation) {
		//Aunque no usemos el user UserToken, hay que rescatarlo.
		//Aplicamos la validación. BindingResult sin errores
		if(!resValidation.hasErrors()) {			
			//Guardamos en DB
			dao.Insert(userToken);
			return "userview/viewRegisterForm";
		}				
		//En caso de errores volver a la página de formulario
		return "userview/userRegisterForm";
	}
	
	//------------ Search ------------//
	@RequestMapping("/searchByID")
	public String searchByID(Model model) {
		//Testing Spring prototype
		SearchParameters searchParams = new SearchParameters();
		model.addAttribute("searchParams", searchParams);
		
		return "userview/userSearchByID";
	}
	
	@RequestMapping("/searchByEmail")
	public String searchByEmail(Model model) {
		//Testing Spring prototype
		SearchParameters searchParams = new SearchParameters();
		model.addAttribute("searchParams", searchParams);
		
		return "userview/userSearchByEmail";
	}
	
	@RequestMapping("/viewUserData")
	public String viewUserData(
		@ModelAttribute("searchParams") SearchParameters searchParams, Model model) {
		User user = null;
		if(searchParams.getId() != -1) {
			user = 
				dao.selectGenericByID(
					User.class, searchParams.getId());
		}		
		else if(searchParams.getEmail() != null) {
			user = 
				dao.selectFirstGenericFromCriteria(
					User.class, "from User u where u.email='"+searchParams.getEmail()+"'");
		}	

		model.addAttribute("user", user);		
		return "userview/viewUserData";
	}	
}
