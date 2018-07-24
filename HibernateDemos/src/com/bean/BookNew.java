package com.bean;

import java.io.Serializable;
import java.sql.Date;

public class BookNew implements Serializable{

	
	private String isbn;
	private String title;
	private String author;
	private Double price;
	private Long stock;
	private Date dOP;
	public BookNew() {
		super();
	}
	public BookNew(String isbn, String title, String author, Double price, Long stock, Date dOP) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.dOP = dOP;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Date getdOP() {
		return dOP;
	}
	public void setdOP(Date dOP) {
		this.dOP = dOP;
	}
	public String toString()
	{
		return this.isbn +" "+ this.author+" " + this.title+" "+this.price+" " + this.dOP;
	}
	
	
}
