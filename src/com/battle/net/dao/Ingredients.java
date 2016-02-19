package com.battle.net.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;



@Entity
@Table(name="ingredients")
public class Ingredients implements java.io.Serializable{

	private Recipes recipe;
	
	private Integer ingredientId;
	private String name;
	private Double amount;
	private String units;
	
	public Ingredients() {
	}	
	
	public Ingredients(Recipes recipe, String name, Double amount, String units) {
		super();
		this.recipe = recipe;
		this.name = name;
		this.amount = amount;
		this.units = units;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "recipeId", nullable = false)
   // @JsonBackReference
	@JsonIgnore
	public Recipes getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipes recipe) {
		this.recipe = recipe;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ingredientid", unique = true, nullable = false)
	public Integer getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
}



/*
@Entity
@Table(name="ingredients")
public class Ingredients implements java.io.Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private Double amount;
	private String units;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "recipeid", nullable = false)
	private Recipes recipe;
	
	public Ingredients() {
	}

	public Ingredients(int id, Recipes recipe, String name, Double amount, String units) {
		super();
		this.id = id;
		this.recipe = recipe;
		this.name = name;
		this.amount = amount;
		this.units = units;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Recipes getRecipeid() {
		return recipe;
	}

	public void setRecipeid(Recipes recipe) {
		this.recipe = recipe;
	}
}
*/