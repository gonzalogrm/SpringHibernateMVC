package com.ggm.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggm.spring.entity.Admin;
import com.ggm.spring.entity.AppConfig;
import com.ggm.spring.persistence.DAO;
import com.ggm.spring.persistence.SearchParameters;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DAO dao;
	
	//------------ Mostrar todos Admin ------------//
	@RequestMapping("/adminlist")
	public String adminsList(Model model) {
		//Get from DAO
		List<Admin> admins= 
			dao.selectGenericFromCriteria(
				Admin.class, "from Admin");
		
		System.out.println(admins.toString());
		
		//Add to model
		model.addAttribute("adminList", admins);		

		return "adminview/adminListView";
	}
	
	//------------ Nuevo Admin ------------//
	@RequestMapping("/newAdminFrom")
	public String newAdminForm(Model model) {
		//Testing Spring prototype
		Admin admin = //new Admin();
			AppConfig.factory.getBean(Admin.class);
		model.addAttribute("admin", admin);
		
		return "adminview/adminRegisterForm";
	}
	
	@PostMapping("/processNewAdmin")
	public String processNewAdmin(@ModelAttribute("admin") Admin adminToken){
		//Guardamos en DB
		dao.Insert(adminToken);
		return "redirect:/index";
	}		
}
