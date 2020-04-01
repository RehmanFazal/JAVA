<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${initParam.AppName}</title>
</head>
<body>
	<h3>Java Crud Example</h3>
	<a href="<c:url value = "AddBook.jsp" />">Add Book</a>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listBook}">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
					<td><a href="MainServlet?action=editBook&id=${book.id}">Edit Book</a> <a href="MainServlet?action=deleteBook&id=${book.id}">Delete Book</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>