package com.battle.net.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/userprofile")
	public String showUserProfile(Model model, Principal principal){
		
		model.addAttribute("userName", principal.getName());
		return "userprofile";
	}
}
