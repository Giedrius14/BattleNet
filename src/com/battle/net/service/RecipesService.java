package com.battle.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battle.net.dao.Recipes;
import com.battle.net.dao.RecipesDao;

@Service("recipesService")
public class RecipesService {

	private RecipesDao recipesDao;
	//private IngredientsDao ingredientsDao;
	
	@Autowired
	public void setRecipesDao(RecipesDao recipesDao) {
		this.recipesDao = recipesDao;
	}
	
	public List<Recipes> getCurrent(){
		return recipesDao.getRecipes();
	}
	
	public Recipes getRecipeById(Integer id) {
		List<Recipes> recipes= recipesDao.getRecipes(id);
		
		return recipes.get(0);
	}
	
	public void createRecipe(Recipes recipe) {
		recipesDao.saveAndUpdate(recipe);
//		ingredientsDao.save(recipe.getIngredients());
	}

/*	public IngredientsDao getIngredientsDao() {
		return ingredientsDao;
	}
	
	@Autowired
	public void setIngredientsDao(IngredientsDao ingredientsDao) {
		this.ingredientsDao = ingredientsDao;
	}*/
}
