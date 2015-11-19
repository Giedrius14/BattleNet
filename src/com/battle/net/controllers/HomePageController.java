package com.battle.net.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.battle.net.dao.Offer;
import com.battle.net.service.OffersService;

@Controller
public class HomePageController {
	
    private static final Logger logger = LogManager.getLogger(HomePageController.class);
	
    @Autowired
    private OffersService offersService;
    
	@RequestMapping("/")
	public String showHome(Model model, Principal principal){
		
		List<Offer> offers= offersService.getCurrent();
		model.addAttribute("offers", offers);
		
		boolean hasOffer = false;
		
		if (principal != null){
			hasOffer = offersService.hasOffer(principal.getName());
		}
		model.addAttribute("hasOffer", hasOffer);
		
		return "home";
	}
}