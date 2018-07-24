package com.casestudy.interfaces;

import java.util.HashMap;
import java.util.List;

import com.casestudy.model.Book;

public interface BookStoreInterface {

	public List<Book> viewBookStore();
	public void addBooksToCart();
}
