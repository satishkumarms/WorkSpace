package com.servlets.service;

import com.servlets.bean.UserBean;
import com.servlets.dao.MovieDao;
import com.servlets.dao.MovieDaoImpl;
import com.servlets.service.MovieService;

public class MovieServiceImpl implements MovieService {
	
	
	private MovieDao mDao;
	
	public MovieServiceImpl()
	{
		mDao = new MovieDaoImpl();
	}

	@Override
	public boolean authenticate(UserBean uBean) {
		
		// TODO Auto-generated method stub
		return mDao.authenticate(uBean);
	
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		mDao.closeConnection();
	}

}