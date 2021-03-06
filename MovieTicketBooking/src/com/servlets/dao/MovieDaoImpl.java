package com.servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlets.bean.UserBean;
import com.servlets.util.DBUtil;

public class MovieDaoImpl implements MovieDao {


	
	private  Connection conn = DBUtil.getConnection();
	public boolean authenticate(UserBean uBean) {
		// TODO Auto-generated method stub
		boolean valid = false;
		
		
		System.out.println("con" + conn);
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("select user_type, password from userdetails where user_name=?");
			stmt.setString(1, uBean.getUser());
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				
				String pswd = rs.getString(2);
				if(pswd!=null && pswd.equals(uBean.getPassword()))
				{
					String type = rs.getString(1);
					valid = true;
					uBean.setType(type);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return valid;
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
