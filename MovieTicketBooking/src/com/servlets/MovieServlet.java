package com.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.mbeans.UserMBean;

import com.servlets.bean.UserBean;
import com.servlets.service.MovieService;
import com.servlets.service.MovieServiceImpl;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet(urlPatterns={"/login","/movieLogin","/usercheck"})
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MovieService mService;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet started");
		mService = new MovieServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getServletPath();
		System.out.println("path  "+ path);
		switch (path) {
		case "/login":
			  request.getRequestDispatcher("login.jsp").forward(request, response);
			   break;
			   
		case "/movieLogin":
			  String user = request.getParameter("login");
			  String pswd = request.getParameter("password");
			  System.out.println("user:" +user);
			  UserBean uBean = new UserBean(user,pswd);
			  boolean valid = mService.authenticate(uBean);
			  System.out.println("valid "+valid);
			  
			  HttpSession session = request.getSession(false);
			  if(valid)
			  {
				  session.setAttribute("muser", user);
				  request.getRequestDispatcher("register.jsp").forward(request, response);
			
			  }
			
			  break;
		 case "/usercheck":
	            String usr = request.getParameter("uname");
	            System.out.println("usr frm ajax: " + usr);
	            response.getWriter().write("got user:"+usr);
	            break;
			

		default:
			break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		mService.closeConnection();
	}

}
