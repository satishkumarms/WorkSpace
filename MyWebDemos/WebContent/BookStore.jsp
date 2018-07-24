<%@page import="java.util.Date"%>
<%@page import="com.casestudy.model.User"%>
<%@page import="com.casestudy.model.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.casestudy.model.Book"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.casestudy.dao.UserDaol"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<form action="ss">
	<% session =  request.getSession(false);
	String role = (String) session.getAttribute("role");
if(role.equals("user"))
{
	User user = (User) session.getAttribute("user");
	
	
	%>
	WELCOME TO STORE<%=user.getUsername() %>
	
	<table border="1">
		<tr>
			<td>BOOK NAME</td>
			<td>BOOK ISBN</td>
			<td>BOOK STOCK</td>
			<td>BOOK AUTHOR</td>
			<td>BOOK PRICE</td>
			<td>QUANTITY REQ</td>
			<td>BUY?</td>
		</tr>

		<% 
List<Book> booklist = (List<Book>) session.getAttribute("list");

for(Book book : booklist)
{
	System.out.println("bookname: "+book.getName());
	
%>
		<tr>
		    
			<th><%= book.getName() %></th>
			<th><%= book.getIsbn() %></th>
			<th><%= book.getStock() %></th>
			<th><%= book.getAuthor() %></th>
			<th><%= book.getPrice() %></th>

			<td><input type="number" value="0" name="quantity" min="0"
				max="<%= book.getStock() %>"></td>
			<td><input type="checkbox" value="<%= book.getIsbn() %>" name="checkbox"> 
			</td>
			    
			

		</tr>
		<% } %>
	</table>
	<input type="submit" value="buy" name="buy">
	</form>
	<% }
else
{
	Admin admin = (Admin) session.getAttribute("user");
	
	%>
	WELCOME TO STORE
	<%=admin.getAdminname() %>
	<table border="1">
		<tr>
			<td>BOOK NAME</td>
			<td>BOOK ISBN</td>
			<td>BOOK STOCK</td>
			<td>BOOK AUTHOR</td>
			<td>BOOK PRICE</td>
		</tr>
		<% 
List<Book> booklist = (List<Book>) session.getAttribute("list");

for(Book book : booklist)
{
	System.out.println("bookname: "+book.getName());
	
%>
		<tr>
			<th><%= book.getName() %></th>
			<th><%= book.getIsbn() %></th>
			<th><%= book.getStock() %></th>
			<th><%= book.getAuthor() %></th>
			<th><%= book.getPrice() %></th>

		</tr>
		<% } %>
	</table>
	<% }

%>

</body>
</html>