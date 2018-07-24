package com.casestudy.dao;

import com.casestudy.interfaces.AdminInterface;
import com.casestudy.model.Admin;
import com.casestudy.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminDaol implements AdminInterface{

	private Connection connection;
	private String dbStringUrl = "jdbc:oracle:thin:@localhost:1521:XE";

	private Admin admin;
	private User user;

	public AdminDaol() {
		admin = new Admin();
		user = new User();
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