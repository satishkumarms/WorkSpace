package com.casestudy.model;

public class User {
	
	private String username;
	private String userpass;
	
	
	public User(String username, String userpass) {
		super();
		this.username = username;
		this.userpass = userpass;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

}
