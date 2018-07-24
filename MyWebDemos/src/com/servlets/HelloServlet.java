package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casestudy.dao.AdminDaol;
import com.casestudy.dao.DbConnection;
import com.casestudy.dao.UserDaol;
import com.casestudy.model.Admin;
import com.casestudy.model.Book;
import com.casestudy.model.User;





public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		List<Book> booklist = new ArrayList<>();
		String path = null;
		String dateofpurchase = null;
		
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy"); 
		
		/*RequestDispatcher rsp = null;*/

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
	/*	String buy=request.getParameter("buy");*/
		HttpSession session = null;
		
	
		
		if(role.equals("user"))
		{ 
			UserDaol userdaol = new UserDaol();
			
			   User user = userdaol.validateUser(username, password);
			   /*System.out.println(user.getUsername());
			   System.out.println(user.getUserpass());*/
			   if(user.getUsername().equals(username) && user.getUserpass().equals(password))
			   {
				   out.println("<h2> valid user or password</h2>");
				   booklist=userdaol.viewBookStore();
				   for(Book book : booklist)
				   {
				   	System.out.println("bookname: "+book.getName());
				   }
				   session = request.getSession(true);
				   
				   dateofpurchase = ft.format(new Date());
				   session.setAttribute("dateofpurchase", dateofpurchase);
				   
				   session.setAttribute("list", booklist);
				   session.setAttribute("role", new String("user"));
				   session.setAttribute("user", user);
				 /*  path = "BookStore.jsp";
				   */
				   path = "ViewstoreJSTL.jsp";
				   
				   RequestDispatcher rsp = request.getRequestDispatcher(path);
				   rsp.forward(request, response);
			   }
			   else
			   {
				   out.println("<h2>  invalid user or password</h2>");
			   }
			   
			}
			
		
		else if(role.equals("admin"))
		{
			AdminDaol admindaol = new AdminDaol();
		
				//System.out.println("connected");
				Admin admin = admindaol.validateAdmin(username, password);
				if(admin.getAdminname().equals(username) && admin.getAdminpass().equals(password))
				{
					booklist = admindaol.viewBookStore();
					 for(Book book : booklist)
					   {
					   	System.out.println("bookname: "+book.getName());
					   }
					   session = request.getSession(true);
					   
					   dateofpurchase = ft.format(new Date());
					   session.setAttribute("dateofpurchase", dateofpurchase);
					   
					   session.setAttribute("list", booklist);
					   session.setAttribute("role", new String("admin"));
					   session.setAttribute("user", admin);
					   path = "BookStore.jsp";
					   RequestDispatcher rsp = request.getRequestDispatcher(path);
					   rsp.forward(request, response);
				}
			}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
