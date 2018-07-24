package com.collections;

public class Book implements Comparable{
	private String isbn;
	private String title;
	private String author;
	private double price;
	private long stock;
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
	public void setPrice(double price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public Book(String isbn, String title, String author, double price,
			long stock) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return isbn+" "+title+" "+author+" "+price+" "+stock;
	}
	@Override
	public int hashCode() {

		return isbn.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;

		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;


		return true;
	}

/*	public int compareTo(Book b1)
	{
		return this.title.compareTo(b1.title);
	}*/
	public int compareTo(Book b1)
	{
		Double d1 = this.price;
		Double d2 = b1.price;
		return d1.compareTo(d2);
	}


}
