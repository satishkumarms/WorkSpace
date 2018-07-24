package com.collections;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Customer {
	private String username;
	private Date dateOfPurchase;
	private Cart cart=new Cart();
	private BookStore bookStore;
	private Set<Book> bookSet;
	public BookStore getBookStore() {
		return bookStore;
	}
	public void setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
	}
	public Set<Book> getBookSet() {
		return bookSet;
	}
	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
	public List<Book> getPurchasedList() {
		return purchasedList;
	}
	public void setPurchasedList(List<Book> purchasedList) {
		this.purchasedList = purchasedList;
	}

	private List<Book> purchasedList;
	
	{
		bookSet = bookStore.getBookSet();
		dateOfPurchase=new Date();
		
	}
	
	public Customer()
	{
		
	}
	public Book searchBook(String isbn)
	{
		for(Book b:bookSet)
		{
			if(b.getIsbn().equals(isbn))
				return b;
		}
		return null;
	}
	
	public boolean addToCart(String isbn)
	{
		purchasedList = cart.getPurchasedList();
		Book bSearched=searchBook(isbn);
		return purchasedList.add(bSearched);
		
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public List<Book> viewCart()
	{
		return cart.getPurchasedList();
	}

}
