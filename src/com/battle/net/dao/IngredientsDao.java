package com.battle.net.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientsDao {

	 @Autowired  
	  SessionFactory sessionFactory;  
	    
	  public void save (Ingredients ingredient)  
	  {  
	    Session session = sessionFactory.getCurrentSession();  
	      
	    session.save(ingredient);  
	  }  
}
