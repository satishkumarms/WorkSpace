package javadatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	private static String dbStringUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	private static Connection connection;
	
	public static void main(String[] args)
	{
		//Statement stmt = null;
		
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
