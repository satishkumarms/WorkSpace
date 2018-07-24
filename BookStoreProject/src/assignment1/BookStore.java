package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore {

	private List<Book> books;
	private int bookIndex;

	//for admin
	private int isbn;
	


	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	//Loading books using constructor
	public BookStore() {
		books = new ArrayList<Book>();
		books.add(new Book(1234,"Textbook1","Writer1",700,12));
		books.add(new Book(1234,"Textbook2","Writer2",500,14));
		books.add(new Book(1234,"Textbook3","Writer3",800,10));
		books.add(new Book(1234,"Textbook4","Writer4",900,16));
		books.add(new Book(1234,"Textbook5","Writer5",100,18));
		//for admin
		
	}

	public BookStore(List<Book> books) {
		super();
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void displayBooks()
	{
		System.out.println("Welcome to store"+"\n --------------------------");
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

	public Boolean checkForBook(String bookname)
	{
		int i=0;
		for(Book book: books)
		{

			if(book.getName().toLowerCase().equals(bookname.toLowerCase()))
			{
				bookIndex =i;
				//System.out.println(books.get(i).getName());
				//System.out.println(i);
				System.out.println("Vola! Book found!");
				System.out.println("-------------------------------");
				System.out.println("BOOKNAME :"+book.getName());
				System.out.println("BOOKAUTHOR :"+book.getAuthor());
				System.out.println("BOOKPRICE :"+book.getPrice());
				System.out.println("BOOKISBN :"+book.getIsbn());
				System.out.println("BOOK-AVIAL-STOCK :"+book.getStock());
				System.out.println("-------------------------------");
				return true;
			}
			i++;
		}

		return false;
	}
	public Boolean checkForStock(int stockreq)
	{
		if(stockreq==0)
		{
			System.out.println("Invalid stock");
			return false;
		}
		else if(stockreq> books.get(bookIndex).getStock())
		{
			System.out.println("Stock avial is less than stock required");
			return false;
		}
		return true;
	}

	public Book bookDetails()
	{
		return books.get(bookIndex);
	}

	public void updateBookStore(int quantity)
	{
		if(books.get(bookIndex).getStock()==quantity)
		{
			books.remove(bookIndex);

		}
		else
		{
			books.get(bookIndex).setStock(books.get(bookIndex).getStock()-quantity);

		}
	}
	//for admin

	public void addBookToStore()
	{
		System.out.println("Enter the isbn of book");
		isbn = new Scanner(System.in).nextInt();
		for(Book book: books)
		{
			if(book.getIsbn()==isbn)
			{
				System.out.println("Book all ready exist"+"\n do you want to add or remove? yes or no");
				String choice = new Scanner(System.in).next();
				if(choice.toLowerCase().equals("yes") || choice.toUpperCase().equals("YES"))
				{
					System.out.println("Do you want to add? yes or no");
					choice = new Scanner(System.in).next();
					if(choice.toLowerCase().equals("yes") || choice.toUpperCase().equals("YES"))
					{
						System.out.println("Enter the quantity to be added");
						int quantity = new Scanner(System.in).nextInt(); 
						book.setStock(book.getStock()+quantity);
						return ;
					}
					else
					{
						while(true)
						{
							System.out.println("Enter the quantity to be removed");
							int quantity = new Scanner(System.in).nextInt();
							if((book.getStock()-quantity)<=0)
							{
								System.out.println("Invalid stock");
							}
							else
							{
								book.setStock(book.getStock()-quantity);
								return ;
							}
						}
					}



				}
				else
				{
					return ;
				}
			}
		}
		System.out.println("Book not found"+"\n Enter the book details");
		Book book = new Book();
		System.out.println("Bookname? ");
		book.setName(new Scanner(System.in).next());
		System.out.println("Bookprice? ");
		book.setPrice(new Scanner(System.in).nextFloat());
		System.out.println("Bookauthor? ");
		book.setAuthor(new Scanner(System.in).next());
		System.out.println("Bookstock? ");
		book.setStock(new Scanner(System.in).nextInt());
		book.setIsbn(isbn);
		books.add(book);
		return ;
		
		
	}

}
