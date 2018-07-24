package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casestudy.model.Book;
import com.casestudy.model.Cart;

public class ServletSession extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String action = (String) request.getParameter("buy");
		String checkbox[] = null;
		Cart cart = new Cart();
		String path = null;
		PrintWriter out = response.getWriter();
		List<Book> booklist = new ArrayList<>(); 

		switch(action)
		{
		case "buy" : checkbox = request.getParameterValues("checkbox");
		/*for(String item: checkbox)
		            	 System.out.println(item);*/
		booklist = (List<Book>)session.getAttribute("list");
		for(Book book: booklist)
		{
			for(int i=0;i<checkbox.length;i++)
			{
				if(book.getIsbn()==Integer.parseInt(checkbox[i]))
				{
					Book book1 = new Book();
					book1 = book;
					System.out.println(book.getAuthor());
					cart.getBooklist().add(book1);
				}

			}

		}
		session.setAttribute("cart", cart);
		path = "Cart.jsp";

		break;

		case "generatebill" : if(cart==null)
		                    {
			                    out.print("<h2>nothing to display<h2>");
 
		                      }
		                   path = "Bill.jsp";
		                     break;
		                     
		                     
		case "signout" : session.invalidate();
		                 path ="LoginPage.html";
		                 break;
		
		}

		/*for(Book book: cart.getBooklist())
		{
			System.out.println(book.getAuthor());
		}*/

		RequestDispatcher rsp = request.getRequestDispatcher(path);
		rsp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
