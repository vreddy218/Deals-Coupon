package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class Customer {
	@Id
	private String id;
	
	private String name;

	private String password;

	private String email;
	
	public Customer()
	{
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
		
	    public Customer(String name, String password, String email) {
	    
			this.name = name;
			this.password = password;
			this.email = email;
		}

		public void purchaseCoupon(Coupon coupon) {
			// TODO Auto-generated method stub
			
		}
}
