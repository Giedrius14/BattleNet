package com.battle.net.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.battle.net.dao.Ingredients;
import com.battle.net.dao.Offer;
import com.battle.net.dao.Recipes;
import com.battle.net.service.RecipesService;

@Controller
public class RecipesController {

	   @Autowired
	    private RecipesService recipesService;
	   
	   
	@RequestMapping("/recipes")
	public String showRecipes(Model model, Principal principal){
		
		List<Recipes> recipes= recipesService.getCurrent();
		model.addAttribute("recipes", recipes);
	/*	model.addAttribute("recipeName", recipes.get(0).getName());
		model.addAttribute("userName", recipes.get(0).getUser().getUsername());
		model.addAttribute("ingredients", recipes.get(0).getIngredients());
		model.addAttribute("description", recipes.get(0).getDescription());*/
		return "recipes";
	}
	

	@RequestMapping("/createrecipe")
	public String createRecipe(Model model, @Valid Recipes recipe, Principal principal){	
		
			String username= principal.getName();
			recipe.getUser().setUsername(username);
			
		//	recipe.setName(name);
		//	recipe.setIngredients(ingredients);
			recipesService.createRecipe(recipe);
			return "home";
	}
	
}
