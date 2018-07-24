package assignment1;

import java.util.Scanner;

public class AdminClient {
	public static void main(String[] args)
	{
		Admin admin = new Admin();
		BookStore bookstore = new BookStore();
		Book book = new Book();
		while(true)
		{
			if(admin.validateAdmin())
			{
				while(true)
				{
					System.out.println("You may add or remove books to store");
					bookstore.addBookToStore();
					System.out.println("Want to continue login to modify changes to store? yes or no ");
					String choice = new Scanner(System.in).next();
					if(choice.toLowerCase().equals("no") || choice.toUpperCase().equals("NO"))
						break;
				}

			}
			else
			{
				System.out.println("Invalid admin username or password");
			}
          System.out.println("Want to login to other admin and continue? yes or no");
          String choice = new Scanner(System.in).next();
          if(choice.toLowerCase().equals("no") || choice.toUpperCase().equals("NO"))
				break;
		}
		System.out.println("Displaying BookStore");
		bookstore.displayBooks();
		System.out.println("Terminated access");
	}

}
