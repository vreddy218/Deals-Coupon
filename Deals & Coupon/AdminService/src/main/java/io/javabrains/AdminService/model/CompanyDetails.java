package io.javabrains.AdminService.model;

import org.springframework.data.annotation.Id;

public class CompanyDetails {
	@Id
	private String comid;
	private String comname;
	private String password;
	private String email;
	
	//GETTERS AND SETTERS
	
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
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
	
	//CONSTRUCTOR WITH FIELDS
	
	public CompanyDetails(String comname, String password, String email) {
		super();
		this.comname = comname;
		this.password = password;
		this.email = email;
	}
	public CompanyDetails() {
		
	}
	@Override
	public String toString() {
		return "Company [comid=" + comid + ", comname=" + comname + ", password=" + password + ", email=" + email + "]";
	}
	
}
