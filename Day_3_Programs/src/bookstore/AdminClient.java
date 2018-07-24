package bookstore;

import java.util.Scanner;

public class AdminClient {

	public static void main(String[] args)
	{
		AdminDetails admin = new AdminDetails();
		Books book = new Books();
		BookStore bookstore = new BookStore();
		//CustomerDetails customer = new CustomerDetails();
		while(true)
		{


			System.out.println("Enter the admin name");
			String adminname = new Scanner(System.in).next();
			System.out.println("Enter the admin password");
			String adminpass = new Scanner(System.in).next();
			Boolean validate = admin.validateUser(adminname, adminpass);
			if(validate==true)
			{

				System.out.println("LOGIN WAS SUCCESSFULL");

				while(true)
				{
					System.out.println("ENTER YOUR CHOICE 1:ADDNEW 2:REMOVE OR UPDATE 3:ENDSESSION 4:DISPLAY");
					int adminchoice = new Scanner(System.in).nextInt();
					if(adminchoice==3)
					{
						break;
					}
					else if(adminchoice==1)
					{

						System.out.println("ENTER THE BOOK ISBN");
						int isbn = new Scanner(System.in).nextInt();
						Boolean isbncheck = bookstore.checkISBN(isbn);
						if(isbncheck == false)
						{ 
							book.setIsbn(isbn);
							System.out.println("ENTER THE BOOK TITLE");
							book.setTitle(new Scanner(System.in).nextLine());
							System.out.println("ENTER THE BOOK AUTHOR");
							book.setAuthorname(new Scanner(System.in).nextLine());
							System.out.println("ENTER THE BOOK PRICE");
							book.setPrice(new Scanner(System.in).nextFloat());
							System.out.println("ENTER THE BOOK STOCK");
							book.setStock(new Scanner(System.in).nextInt());
							bookstore.addBook(book);
							book = new Books();
						}
						else
						{
							System.out.println("BOOK ALREADY EXIST");
						}


					}
					else if(adminchoice==2)
					{
						System.out.println("ENTER THE BOOKISBN TO REMOVE OR UPDATE");
						int isbn = new Scanner(System.in).nextInt();
						Boolean isbncheck = bookstore.checkISBN(isbn);
						if(isbncheck)
						{
							System.out.println("ENTER 1: TO REMOVE 2:UPDATE");
							int removeorupdate = new Scanner(System.in).nextInt();
							if(removeorupdate==1)
							{
								System.out.println("ENTER THE QUANTITY OF BOOKS TO BE REMOVED");
								int remove = new Scanner(System.in).nextInt();
								int update = book.getStock()-remove;
								if(update==0)
								{
									bookstore.removeBook(isbn);

								}
								else
								{
									bookstore.updateBooksAdmin(isbn,update);
								}
							}
							else
							{
								System.out.println("ENTER THE QUANTITY OF BOOKS UPDATED");
								int update = new Scanner(System.in).nextInt();
								bookstore.updateBooksAdmin(isbn, update);
							}

						}
						else
						{
							System.out.println("BOOK ISBN NOT FOUND");
						}


					}
					else
					{
						bookstore.displaybooks();
					}
				}
//////
			}
			else
			{
				System.out.println("INVALID ADMIN" +"\n "+ " RE-TRY");
			}

			System.out.println("Session terminated for"+ adminname);
			System.out.println("TYPE yes to continue login session for other user or else type no to terminate");
			String choice = new Scanner(System.in).next();
			if(choice.equals("no") || choice.equals("NO"))
			{
				break;
			}
		}

	}

}
