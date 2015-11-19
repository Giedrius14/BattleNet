package com.battle.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battle.net.dao.Message;
import com.battle.net.dao.Recipes;
import com.battle.net.dao.RecipesDao;

@Service("recipesService")
public class RecipesService {

	private RecipesDao recipesDao;
	
	@Autowired
	public void setRecipesDao(RecipesDao recipesDao) {
		this.recipesDao = recipesDao;
	}
	
	public List<Recipes> getCurrent(){
		return recipesDao.getRecipes();    //  Selektina is DB
	}
	
	public void createRecipe(Recipes recipe) {
		recipesDao.saveAndUpdate(recipe);
	}
}
