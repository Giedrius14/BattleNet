package com.battle.net.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="recipes")
public class Recipes {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String description;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy="recipeid")
    private List<Ingredients> ingredients = new ArrayList<Ingredients>(0);

	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	
	public Recipes() {
		this.user = new User();
	}
		
	public Recipes(int id, String name, String description, List<Ingredients> ingredients, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Ingredients> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set ingredients) {
		this.ingredients = (List<Ingredients>) ingredients;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername(){
		return user.getUsername();
	}
}
