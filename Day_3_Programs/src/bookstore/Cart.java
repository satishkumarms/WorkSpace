package bookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Cart {


	private List<Books> userbooks;
	//private Set<Books> set;

	//constructors
	public Cart() {
		userbooks = new ArrayList<>();
		//set = new HashMap<Books>();


	}




	public Cart(List<Books> userbooks) {
		super();
		this.userbooks = userbooks;
	}




	//getters and setters
	public List<Books> getUserbooks() {
		return userbooks;
	}


	public void setUserbooks(List<Books> userbooks) {
		this.userbooks = userbooks;
	}

	public void displayUserBooks()
	{
		if(userbooks.size()==0)
		{
			System.out.println("OOPS NOTHING TO DISPLAY");
			return;
		}

		for(Books book: userbooks)
		{
			System.out.println("BookNAME: "+book.getTitle());
		}
	}

	public void addBooks(Books b1)
	{
		Books book = new Books();
		int flag = 0;
		book.setAuthorname(b1.getAuthorname());
		book.setIsbn(b1.getIsbn());
		book.setPrice(b1.getPrice());
		book.setTitle(b1.getTitle());
		book.setStock(b1.getStock());
		for(Books book1: userbooks)
		{
			if(book1.getIsbn()==book.getIsbn())
			{
				book1.setStock(book1.getStock()+book.getStock());
				flag = 1;
				
			}
			
		}
		if(flag==0)
		{
		userbooks.add(book);
		}
		System.out.println("BOOK WAS SUCCESFFULY ADDED");
		while(true)
		{
			System.out.println("Want to check the cart");
			System.out.println("Enter 1");
			int cartchoice = new Scanner(System.in).nextInt();
			if(cartchoice !=1)
				return;
			this.displayBooks();


		}
	}

	public void displayBooks()
	{
		System.out.println("Books in the Cart");
		for(Books ubook : userbooks)
		{

			System.out.println(ubook.getTitle());
			System.out.println(ubook.getStock());
		}
	}




}
