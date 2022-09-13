package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Company {
	@Id
	private String id;
	

	private  String comname;

	private  List<Categories> categories;

	public Company() {

	}


	public String getComname() {
		return comname;
	}


	public void setComname(String comname) {
		this.comname = comname;
	}


	public List<Categories> getCategories() {
		return categories;
	}


	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}


	public Company(String comname, List<Categories> categories) {
		super();
		this.comname = comname;
		this.categories = categories;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", comname=" + comname + ", categories=" + categories + "]";
	}

}
