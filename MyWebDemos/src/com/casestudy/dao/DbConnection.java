package com.casestudy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static private Connection connection;
	

	static public Connection getConnection() {
		return connection;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public Boolean connectToDb(String dbStringUrl,String dbDriver, String username,String password)
	{
		try {
			//load the Driver Class
		/*	Class.forName("oracle.jdbc.driver.OracleDriver");*/
			Class.forName(dbDriver);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//get the DB connection
		try {
			/*connection = DriverManager.getConnection(dbStringUrl, "satishkumar", "satishkumarms");*/
			connection = DriverManager.getConnection(dbStringUrl,username,password);
			
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


	

}
