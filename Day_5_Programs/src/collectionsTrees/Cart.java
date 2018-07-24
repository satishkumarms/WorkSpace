package com.collections;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Book> purchasedList=new ArrayList<Book>();

	public List<Book> getPurchasedList() {
		return purchasedList;
	}

	public void setPurchasedList(List<Book> purchasedList) {
		this.purchasedList = purchasedList;
	}
	
	

}
