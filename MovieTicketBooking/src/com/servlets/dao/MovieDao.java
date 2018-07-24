package com.servlets.dao;

import com.servlets.bean.UserBean;

public interface MovieDao {

	boolean authenticate(UserBean uBean);

	void closeConnection();

	

}
