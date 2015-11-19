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
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}
	
	public void saveAndUpdate(Recipes recipe) {
		//System.out.println("MsgDAO"+message);
		session().saveOrUpdate(recipe);
	}
}
