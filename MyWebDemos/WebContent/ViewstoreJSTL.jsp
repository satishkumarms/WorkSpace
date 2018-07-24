<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ss">

		<c:if test="${role=='user'}">
	
	WELCOME TO STORE ${user.username}
	
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

				<c:forEach var="book" items="${list}">
					<tr>

						<th>${book.name}</th>
						<th>${book.isbn}</th>
						<th>${book.stock}</th>
						<th>${book.author}</th>
						<th>${book.price}</th>

						<td><input type="number" value="0" name="quantity" min="0"
							max="${book.stock}"></td>
						<td><input type="checkbox" value="${book.isbn}"
							name="checkbox"></td>



					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="buy" name="buy">
	</form>
	</c:if>

	<c:if test="${role=='admin'}">
WELCOME TO STORE ${user.username}
	
	<table border="1">
			<tr>
				<td>BOOK NAME</td>
				<td>BOOK ISBN</td>
				<td>BOOK STOCK</td>
				<td>BOOK AUTHOR</td>
				<td>BOOK PRICE</td>
			</tr>

			<c:forEach var="book" items="${list}">
				<tr>

					<th>${book.name}</th>
					<th>${book.isbn}</th>
					<th>${book.stock}</th>
					<th>${book.author}</th>
					<th>${book.price}</th>

				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="buy" name="buy">
		</form>

	</c:if>
</body>
</html>