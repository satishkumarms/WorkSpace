package com.collections;

import java.util.HashSet;
import java.util.Set;

public class BookStore {
	
	//set of Books
	static Set<Book> bookSet=new HashSet<Book>();
	
	public static Set<Book> getBookSet() {
		return bookSet;
	}

	static{
		
		bookSet.add(new Book("1", "C", "YK", 200, 100l));
		bookSet.add(new Book("2", "C++", "PK", 300, 500l));
		bookSet.add(new Book("3", "Java", "Patrick", 100, 550l));
		bookSet.add(new Book("6", "CSharp", "xyz", 200, 100l));
		bookSet.add(new Book("7", "Html", "RVK", 100, 100l));
	}

	
}
