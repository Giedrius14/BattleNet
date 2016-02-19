package com.battle.net.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("ingredientsDao")
public class IngredientsDao {

	 @Autowired  
	  SessionFactory sessionFactory;  
	    
	  public void save (List<Ingredients> list){  
	    Session session = sessionFactory.getCurrentSession();  
	/*    for (Ingredients item : list){
	    	item.setRecipe();
	    }
	    */
	    session.save(list);  
	  }

	public void save(Ingredients ingredients) {
	    Session session = sessionFactory.getCurrentSession();     
	    session.save(ingredients);  	
	}  
}
