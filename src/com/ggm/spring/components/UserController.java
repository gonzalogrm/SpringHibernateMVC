package com.ggm.spring.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggm.spring.entity.User;
import com.ggm.spring.persistence.DAO;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("/userlist")
	public String userList(Model model) {
		//Get from DAO
		List<User> users= 
			dao.selectGenericFromCriteria(User.class, "from User");
			//dao.selectUsers();
		
		System.out.println(users.toString());
		
		//Add to model
		model.addAttribute("userList", users);		

		return "userListView";
	}
}
