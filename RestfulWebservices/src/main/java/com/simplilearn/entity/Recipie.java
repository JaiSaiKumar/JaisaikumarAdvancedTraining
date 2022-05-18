package com.simplilearn.entity;

import javax.persistence.*;

@Entity
public class  Recipie{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String ingrediants;
	private String imgurl;
	private String category;
	@Lob
	private String CookingSteps;
	public Recipie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Recipie(int id, String name, String ingrediants, String imgurl, String category, String cookingSteps) {
		super();
		this.id = id;
		this.name = name;
		this.ingrediants = ingrediants;
		this.imgurl = imgurl;
		this.category = category;
		this.CookingSteps = cookingSteps;
	}

	public String getCookingSteps(){
		return CookingSteps;
	}
	public void setCookingSteps(String cookingSteps) {
		CookingSteps = cookingSteps;
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
	public String getIngrediants() {
		return ingrediants;
	}
	public void setIngrediants(String ingrediants) {
		this.ingrediants = ingrediants;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
	