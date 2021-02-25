package com.hcl.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.taskmanager.entity.User;
import com.hcl.taskmanager.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/sign-up")
	public String registerUser(Model model) {
		model.addAttribute("newUser", new User());
		
		return "sign-up";
	}
	
	@PostMapping("/save-user")
	public String saveUser(User newUser) {
		userService.saveUser(newUser);
		
		return "redirect:/";
	}
	
	

}
