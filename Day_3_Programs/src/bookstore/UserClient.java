package bookstore;

import java.util.Scanner;

public class UserClient {

	public static void main(String[] args)
	{
		CustomerDetails customer = new CustomerDetails();
		System.out.println("      Namaste!\nWELCOME TO BOOK STORE"+"\n"+"   BOOK DETAILS ");
		System.out.println("--------------------");
		BookStore bookstore = new BookStore();
		bookstore.addBooks();
		while(true)
		{
			bookstore.displaybooks();
			System.out.println("WHICH BOOK IS NEEDED?"+" \n"+"ENTER THE BOOK-TITLE");
			String title = new Scanner(System.in).next();
			Boolean found = bookstore.search(title);
			if(found==true)
			{
				System.out.println("HOW MUCH "+title.toUpperCase()+" BOOKS REQUIRED?");
				bookstore.showStockDetails();
				System.out.println("ENTER THE QUANTITY-");
				int stockreq = new Scanner(System.in).nextInt();
				int stockavil = bookstore.getStockDetails();
				//System.out.println("Checking stock  :"+ stockavil);
				while(true)
				{
					if(stockreq<=stockavil)
					{
						int newstock = stockavil-stockreq;
						bookstore.updateBooks(newstock,stockreq);
						//need to add cart 



						break;
					}
					else
					{
						System.out.println("REQUIREMENT IS MORE THE AVAILBLE");
						bookstore.showStockDetails();
						stockreq = new Scanner(System.in).nextInt();
					}

				}
			}
			else
			{
				System.out.println("book not found");
				System.out.println("Re-enter the name of book");
			}


			System.out.println("CONTINUE SHOPPING? yes|no");
			String choice = new Scanner(System.in).next();
			if(!(choice.equals("yes") || choice.equals("YES")))
			{
				System.out.println("BILL GENERATION");
				System.out.println("ENTER THE USERNAME");
				String username = new Scanner(System.in).nextLine();
				System.out.println("ENTER THE USERNAME");
				String userpass = new Scanner(System.in).nextLine();
				//Boolean valid = customer.validateUser(username, userpass);
				if(customer.validateUser(username, userpass))
				{
					System.out.println("SUCCESSFUL LOGIN");
					System.out.println("USER :"+username);	
					customer.generateBillForCustomer();
					break;
				}
			}

		}
	}

}
