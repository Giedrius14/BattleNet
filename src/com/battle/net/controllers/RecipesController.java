package com.battle.net.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battle.net.dao.Ingredients;
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
		return "recipes";
	}
	

	@RequestMapping("/createrecipe")
	public String createRecipe(Model model, @Valid Recipes recipe, Principal principal){	
		
			String username= principal.getName();
			recipe.getUser().setUsername(username);
			recipesService.createRecipe(recipe);
			return "recipes";
	}

	@RequestMapping(value = "/openrecipes", method= RequestMethod.POST, produces="application/json")
	public @ResponseBody String openRecipe(@RequestBody Map<String, Object> data) {//@RequestBody Map<String, Object> data
		Recipes recipe = recipesService.getRecipeById(Integer.parseInt(data.get("id").toString()));
		//Recipes recipe = recipesService.getRecipeById(6);
		List<Ingredients> ingredients = recipe.getIngredients();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipe);
		//	System.out.println(jsonInString);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	    return jsonInString;
	}
	/*@RequestMapping(value = "/openrecipes", method = RequestMethod.GET)
	public @ResponseBody String openRecipe() {//@RequestBody Map<String, Object> data
		//recipe = recipesService.getRecipeById(Integer.parseInt(data.get("id").toString()));
		Recipes recipe = recipesService.getRecipeById(6);
		List<Ingredients> ingredients = recipe.getIngredients();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipe);
		//	System.out.println(jsonInString);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	    return jsonInString;
	}*/
}