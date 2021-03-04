package com.zalost.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zalost.spring.config.AppConfig;


@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/goToForm")
	public String goToForm(Model model) {
		//Testing Spring prototype
		User user = AppConfig.factory.getBean(User.class);
		System.out.println(user.toString());
		User user2 = AppConfig.factory.getBean(User.class);
		System.out.println(user2.toString());
		
		model.addAttribute("user", user);
		
		return "userRegisterForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("user") User userToken) {
		//Aunque no usemos el user UserToken, hay que rescatarlo.
		return "viewRegisterForm";
	}
}
