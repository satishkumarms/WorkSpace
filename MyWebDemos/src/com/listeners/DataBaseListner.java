package com.listeners;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.casestudy.dao.DbConnection;

/**
 * Application Lifecycle Listener implementation class DataBaseListner
 *
 */
@WebListener
public class DataBaseListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
	
	private String dbStringUrl;
	private String dbDriver;
	private String username;
	private String password;

    public DataBaseListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	
    	 dbStringUrl = event.getServletContext().getInitParameter("dbStringUrl");
	     dbDriver = event.getServletContext().getInitParameter("dbDriver");
	      username = event.getServletContext().getInitParameter("username1");
		 password = event.getServletContext().getInitParameter("password1");
		 DbConnection dbconnection = new DbConnection();
		 
		 if(dbconnection.connectToDb( dbStringUrl, dbDriver, username,password))
		 {
			System.out.println("Connected to db");
		 }
    	
    	
    	
    }
	
}
