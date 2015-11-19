package com.battle.net.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredients implements java.io.Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private Double amount;
	private String units;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "recipeid")
	private Recipes recipeid;
	
	public Ingredients() {
	}

	public Ingredients(int id, Recipes recipeid, String name, Double amount, String units) {
		super();
		this.id = id;
		this.recipeid = recipeid;
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
		return recipeid;
	}

	public void setRecipeid(Recipes recipeid) {
		this.recipeid = recipeid;
	}
}
