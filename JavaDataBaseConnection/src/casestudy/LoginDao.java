package casestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private Connection connection;
	private String dbStringUrl = "jdbc:oracle:thin:@localhost:1521:XE";
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//addLogin
	public int addLogin(String username,String password, String role)
	{
		int n=0;

		try {
			String insertString = "insert into login values(?,?,?)" ;
			PreparedStatement pstmt = connection.prepareStatement(insertString);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, role);

			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return n;
		}
	}

	public int deleteLogin(String username)
	{
		int n=0;
		String deleteString = "delete from login where username=?";

		try {
			if(searchLogin(username))
			{
				PreparedStatement pstmt = connection.prepareStatement(deleteString);


				pstmt.setString(1, username);
				n = pstmt.executeUpdate();
			}
			else
			{
				System.out.println("Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally 
		{
			return n;
		}



	}

	public Boolean searchLogin(String username)
	{
		String searchQuery = "select username from login where username=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(searchQuery);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
