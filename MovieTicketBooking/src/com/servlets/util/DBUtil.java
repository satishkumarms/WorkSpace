package com.servlets.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	
	private static Connection conn;
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			if(conn==null || conn.isClosed())
			{
				try {
					//Class.forName("jdbc:oracle:thin:@localhost:1521:XE");
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} 
				 catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","satishkumar","satishkumarms");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	
	
	
}
