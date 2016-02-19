package com.battle.net.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("recipesDao")
public class RecipesDao {

	
	@Autowired
	private SessionFactory sessionFactory; 
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<Recipes> getRecipes() {
		Criteria crit= session().createCriteria(Recipes.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	public List<Recipes> getRecipes(Integer id) {
		Criteria crit= session().createCriteria(Recipes.class);
	//	crit.createAlias("recipeId", "u");
		//crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("recipeId", id));
		return crit.list();
	}
	
	public void saveAndUpdate(Recipes recipe) {
		//System.out.println("MsgDAO"+message);
		session().saveOrUpdate(recipe);
		
		for (Ingredients item : recipe.getIngredients()){
	    	item.setRecipe(recipe);
	    	session().save(item);  
	    }    
	}
}
