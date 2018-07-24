package com.bean;

import java.util.List;

public class Customer {

	private String username;
	private String email;
	private List<Complaint> complaintlist;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Complaint> getComplaintlist() {
		return complaintlist;
	}
	public void setComplaintlist(List<Complaint> complaintlist) {
		this.complaintlist = complaintlist;
	}
	public Customer(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	public Customer() {
		super();
	}
	
	
}
