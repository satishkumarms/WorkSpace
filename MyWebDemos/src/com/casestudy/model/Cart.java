package com.casestudy.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	
	private List<Book> booklist;
	private String dateofpurchase;
	public Cart() {
		booklist = new ArrayList<>();
		dateofpurchase = null;
	}
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	public String getDateofpurchase() {
		return dateofpurchase;
	}
	public void setDateofpurchase(String dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}
	
	
	

}
