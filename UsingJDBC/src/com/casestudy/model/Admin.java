package com.casestudy.model;

public class Admin {

	
	private String adminname;
	private String adminpass;
	public Admin() {
		
	}
	public Admin(String adminname, String adminpass) {
		super();
		this.adminname = adminname;
		this.adminpass = adminpass;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	
}
