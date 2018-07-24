package assignment1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserClient {

	public static void main(String[] args)
	{
		Client client = new Client();
		Billing clientbill = new Billing();
		BookStore bookstore = new BookStore();
		Cart cart = new Cart();
		Boolean flag = true;
		
		int quantity;
		String date;
		while(true)
		{
		bookstore.displayBooks();
		System.out.println("Enter the book of your choice");
		String bookname = new Scanner(System.in).next();
		if(bookstore.checkForBook(bookname))
		{
			System.out.println("Enter the number of quantity req?:");
			quantity = new Scanner(System.in).nextInt();
			if(bookstore.checkForStock(quantity))
			{
				
				SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    Date now = new Date();
			    date = simpledateformat.format(now);
			    Book book = new Book();
			    book = bookstore.bookDetails();
			    book.setStock(quantity);
			 
			    //ADD BOOK TO CART
			    cart.addToCart(book, date);
			    System.out.println("Successfull added to cart");
			    //UPDATE THE STOCK IN THE BOOKSTORE
			    bookstore.updateBookStore(quantity);
			    
			    System.out.println("WANT TO VIEW THE CART? yes or no?");
			    String choice = new Scanner(System.in).next();
			    if(choice.toLowerCase().equals("yes") || choice.toUpperCase().equals("YES"))
			    {
			    	cart.viewCart();
			    }
			    
			   
				
			}
			
			
		}
		else
		{
			System.out.println("OOPS! book not found");
		}
		System.out.println("Continue shopping? yes or no");
		String usershoppingchoice = new Scanner(System.in).next();
		if(usershoppingchoice.toLowerCase().equals("no") || usershoppingchoice.toUpperCase().equals("NO"))
		{
			flag = false;
			System.out.println("Moving to Billing");
			//ATHUNTICATE USER
			System.out.println("Enter User details");
			if(!client.validateUser())
			{
				while(true)
				{
					System.out.println("RE-TRY");
					if(client.validateUser())
						break;
				}
			}
			client.addCart(cart);
			clientbill.addClientBill(client);
			clientbill.generateBill();
			break;
		}
		
		
		}
		
		
		
		
	}
}
