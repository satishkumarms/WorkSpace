package com.casestudy.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import com.casestudy.interfaces.BookStoreInterface;
import com.casestudy.interfaces.UserInterface;
import com.casestudy.model.Book;
import com.casestudy.model.User;

public class UserDaol implements UserInterface,BookStoreInterface {

	private Connection connection;
	private String dbStringUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	private User user ;
	private HashMap<String , Book> availbooks;


	public UserDaol() {
		user = new User();
		availbooks = new HashMap<String, Book>();
	}

	public Boolean connectToDb()
	{
		try {
			//load the Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//get the DB connection
		try {
			connection = DriverManager.getConnection(dbStringUrl, "satishkumar", "satishkumarms");
			if(connection!=null)
			{
				System.out.println("connection successfull");
			}
			else
			{
				System.out.println("Could not connect");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	//display yes or no? with messages
	public Boolean displayMessage(String message)
	{
		System.out.println(message +" yes or no?");
		String choice = new Scanner(System.in).next();
		if(choice.toLowerCase().equals("yes") || choice.toUpperCase().equals("YES"))
		{
			return true;
		}
		return false;
	}




	//validate userlogin
	public Boolean validateUser() 
	{
		System.out.println("Enter the username");
		user.setUsername(new Scanner(System.in).next());
		System.out.println("Enter the password");
		user.setUserpass(new Scanner(System.in).next());
		String searchQuery = "select username from login where username=? and userpass=? and role='user'";
		try 
		{
			PreparedStatement pstmt = connection.prepareStatement(searchQuery);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getUserpass());
			ResultSet rs = pstmt.executeQuery();

			if(rs.next())
			{
				if(rs.getString(1).equals(user.getUsername()))
					return true;

			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;



	}
	//view books store-bookstoreinterface
	public void viewBookStore()
	{
		///need to be implemented
		String viewQuery = "select * from bookstore";

		try {
			PreparedStatement pstmt = connection.prepareStatement(viewQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("-------------------------------");
			while(rs.next())
			{
				Book book = new Book();
				System.out.println("BookIsbn:: "+rs.getInt(1));
				book.setIsbn(rs.getInt(1));
				System.out.println("BookTitle:: "+rs.getString(2));
				book.setName(rs.getString(2));
				System.out.println("BookAuthor:: "+rs.getString(3));
				book.setAuthor(rs.getString(3));
				System.out.println("BookPrice:: "+rs.getFloat(4));
				book.setPrice(rs.getFloat(4));
				System.out.println("BookStock:: "+rs.getInt(5));
				book.setStock(rs.getInt(5));
				availbooks.put(book.getName(), book);
				System.out.println("-------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void addBooksToCart()
	{
		if(this.displayMessage("want to shop"))
		{
			System.out.println("Enter the book title");
			String bookname = new Scanner(System.in).next();
			if(availbooks.containsKey(bookname))
			{
				Book book = new Book();
				book = availbooks.get(bookname);
				
				while(true)
				{
					System.out.println("Enter the number of stock required");
					int stockreq = new Scanner(System.in).nextInt();

					if(stockreq==0 || stockreq>book.getStock())
					{
						System.out.println("invalid stock retry");
					}
					else if(stockreq==book.getStock() || stockreq<book.getStock())
					{
					       
					  	
					}
				}
			}
		}
	}
}
