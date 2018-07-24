package com.servlets.service;

import com.servlets.bean.UserBean;

public interface MovieService {

	boolean authenticate(UserBean uBean);

	void closeConnection();

}
