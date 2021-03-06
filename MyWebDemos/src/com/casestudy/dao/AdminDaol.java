package com.casestudy.dao;

import com.casestudy.interfaces.AdminInterface;
import com.casestudy.interfaces.BookStoreInterface;
import com.casestudy.model.Admin;
import com.casestudy.model.Book;
import com.casestudy.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDaol implements AdminInterface,BookStoreInterface{

	private Connection connection;
	private String dbStringUrl = "jdbc:oracle:thin:@localhost:1521:XE";

	private Admin admin;
	private User user;
	private List<Book> booklist;
	
	

	public AdminDaol() {
		admin = new Admin();
		user = new User();
		booklist = new ArrayList<>();
		//new changes
		 connection = DbConnection.getConnection();
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

	//SINCE ADMINdaol uses bookstoreinterface it has to implement the addbookstocart()

	public void addBooksToCart(){

	}







	public Boolean validateAdmin()
	{
		System.out.println("Enter the ADMIN-username");
		admin.setAdminname(new Scanner(System.in).next());
		System.out.println("Enter the ADMIN-password");
		admin.setAdminpass(new Scanner(System.in).next());

		String searchQuery = "select username from login where username=? and userpass=? and role='admin'";
		try 
		{
			PreparedStatement pstmt = connection.prepareStatement(searchQuery);
			pstmt.setString(1, admin.getAdminname());
			pstmt.setString(2, admin.getAdminpass());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(admin.getAdminname()))
				{
					System.out.println("admin login was successful");
					return true;

				}

			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	//overloaded adminvalidate
	public Admin validateAdmin(String username,String password)
	{

		admin.setAdminname(username);

		admin.setAdminpass(password);

		String searchQuery = "select username from login where username=? and userpass=? and role='admin'";
		try 
		{
			PreparedStatement pstmt = connection.prepareStatement(searchQuery);
			pstmt.setString(1, admin.getAdminname());
			pstmt.setString(2, admin.getAdminpass());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(admin.getAdminname()))
				{
					System.out.println("admin login was successful");
					return admin;

				}

			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}


	public List<Book> viewBookStore()
	{
		String viewQuery = "select * from bookstore";
		try {
			PreparedStatement pstmt = connection.prepareStatement(viewQuery);
			ResultSet rs = pstmt.executeQuery();
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
				booklist.add(book);
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return booklist;
		}

	}









	public Boolean validateSuperAdmin()
	{
		String searchQuery = "select privilege from login where username=? and userpass=? and role='admin' and privilege=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(searchQuery);
			pstmt.setString(1, admin.getAdminname());
			pstmt.setString(2, admin.getAdminpass());
			pstmt.setString(3, "super");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals("super"))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void addUser()
	{
		int numberofrows=0;
		System.out.println("Do you want to add user? yes or no?");
		String choice =  new Scanner(System.in).next();
		if(choice.toLowerCase().equals("yes") || choice.toUpperCase().equals("YES"))
		{
			if(this.validateSuperAdmin())
			{
				System.out.println("Enter the user name");
				user.setUsername(new Scanner(System.in).next());
				System.out.println("Enter the user password");
				user.setUserpass(new Scanner(System.in).next());
				String insertQuery = "insert into login values(?,?,'user',null)";
				try {
					PreparedStatement pstmt = connection.prepareStatement(insertQuery);
					pstmt.setString(1, user.getUsername());
					pstmt.setString(2, user.getUserpass());
					numberofrows = pstmt.executeUpdate();

					//setautocommit on
					connection.setAutoCommit(true);
					System.out.println("updated rows :"+numberofrows);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}




			}
			else
			{
				System.out.println("OOPS! Sorry you are not Super-Admin");
			}

		}


	}

	public void deleteUser()
	{
		int numberofrows=0;
		System.out.println("Do you want to delete user? yes or no?");
		String choice =  new Scanner(System.in).next();
		if(choice.toLowerCase().equals("yes") || choice.toUpperCase().equals("YES"))
		{
			if(this.validateSuperAdmin())
			{
				System.out.println("Enter the user name");
				user.setUsername(new Scanner(System.in).next());
				String deleteQuery = "delete from login where username=? and role='user'";
				try {
					PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
					pstmt.setString(1, user.getUsername());
					connection.setAutoCommit(false);
					numberofrows = pstmt.executeUpdate();
					System.out.println("updated rows :"+numberofrows);
					System.out.println("Keep the changes made to DB");
					if(new Scanner(System.in).next().toLowerCase().equals("yes"))
					{
						connection.setAutoCommit(true);
						System.out.println("Your Updation is Successfully updated");
					}
					else
					{
						connection.rollback();
						connection.setAutoCommit(true);
						System.out.println("Your Updation is Successfully updated");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
			else
			{
				System.out.println("OOPS! Sorry you are not Super-Admin");
			}

		}
	}
}