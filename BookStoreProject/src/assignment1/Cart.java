package assignment1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Book> books;
	private Book userBook;
	private String dateofpurchace;
	
	
	
	
	public Cart() {
		books = new ArrayList<Book>();
		userBook = new Book();
	}
	public Cart(List<Book> book, String dateofpurchace) {
		super();
		this.books = book;
		this.dateofpurchace = dateofpurchace;
	}
	public List<Book> getBook() {
		return books;
	}
	public void setBook(List<Book> book) {
		this.books = book;
	}
	public String getDateofpurchace() {
		return dateofpurchace;
	}
	public void setDateofpurchace(String dateofpurchace) {
		this.dateofpurchace = dateofpurchace;
	}
	public void addToCart(Book book, String dateofpurchase)
	{
		userBook = book;
		this.dateofpurchace = dateofpurchase;
		books.add(userBook);
	}
	public void viewCart()
	{
		if(books==null)
		{
			System.out.println("Nothing to display");
			return;
		}
		System.out.println("BOOKS IN CART"+"\n ---------------------");
		for(Book book: books)
		{
			
			System.out.println("BOOKNAME :"+book.getName());
			System.out.println("BOOKAUTHOR :"+book.getAuthor());
			System.out.println("BOOKPRICE :"+book.getPrice());
			System.out.println("BOOKISBN :"+book.getIsbn());
			System.out.println("BOOK-AVIAL-STOCK :"+book.getStock());
			System.out.println("-------------------------------");
		}
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Book getUserBook() {
		return userBook;
	}
	public void setUserBook(Book userBook) {
		this.userBook = userBook;
	}
	
	

}
