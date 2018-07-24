package bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

	private List<Books> books;
	private int index;
	private int stock;
	private Cart cart1;
	private Cart cart;
	private CustomerDetails cum;
	//constructors
	public BookStore() {

          books = new ArrayList<>();
          cart = new Cart();
          cum = new CustomerDetails();
	}



	public BookStore(List<Books> books) {
		super();
		this.books = books;
	}



	//getters and setters
	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public void addBooks()
	{  
		books = new ArrayList<>();
		Books book = new Books();
		book.setAuthorname("Dennis");
		book.setIsbn(1234);
		book.setPrice(2000);
		book.setStock(12);
		book.setTitle("Mystory");
		books.add(book);
		book = new Books();
		book.setAuthorname("Satish");
		book.setIsbn(2345);
		book.setPrice(3000);
		book.setStock(10);
		book.setTitle("Yourstory");
		books.add(book);
		book = new Books();
		book.setAuthorname("Shesha");
		book.setIsbn(4556);
		book.setPrice(6000);
		book.setStock(2);
		book.setTitle("Ourstory");
		books.add(book);

	}

	public void displaybooks()
	{   
		if(books.size()==0)
		{
			System.out.println("Nothing to display");
			return;
		}
		for(Books book:books)
		{
			
			System.out.println("BookName: "+book.getTitle());
			System.out.println("Author name: "+book.getAuthorname());
			System.out.println("BookISBN: "+ book.getIsbn());
			System.out.println("Price: "+book.getPrice());
			System.out.println("Stock : "+book.getStock());
			System.out.println("--------------------");

		}
	}
	public Boolean search(String title)
	{
		int i=0;
		for(Books book:books)
		{
			
			
			if(book.getTitle().toLowerCase().contains(title) || book.getTitle().toUpperCase().contains(title))
			{
				//System.out.println(book.getTitle()+" "+i);
				index =i;
				stock = book.getStock();
				return true;
			}
			i++;
		}
		return false;
	}
	public void showStockDetails()
	{
		System.out.println("AVILABLE STOCK IS "+stock);
	}
	public int getStockDetails()
	{
		return stock;
	}

	public void updateBooks(int newStock,int stockreq)
	{
	
		//System.out.println(books.get(index));
		
		Books book = new Books();
	    book = books.get(index);
		book.setStock(stockreq);
		
		cart.addBooks(book);
		cum.sendCustomerCartDetails(cart);
		
		books.get(index).setStock(newStock);
		cart1 = cart;
		
	
		if(books.get(index).getStock() == 0)
		{
			books.remove(index);
		}

		this.displaybooks();
	}
	public Boolean checkISBN(int isbn)
	{
		System.out.println(isbn);
		for(Books book: books)
		{
			if(book.getIsbn()==isbn)
				return true;
		}
		return false;
	}
	
	public void addBook(Books book)
	{
	   books.add(book);
		
	}
	public void removeBook(int isbn)
	{
		for(Books book: books)
		{
			if(book.getIsbn()==isbn)
			{
				books.remove(book);
				return;
			}
		}
	}
	public void updateBooksAdmin(int isbn,int update)
	{
		for(Books book: books)
		{
			if(book.getIsbn()==isbn)
				book.setStock(update);
		}
	}


}
