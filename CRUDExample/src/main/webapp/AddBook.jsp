<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${ empty book }">
		<h3>Add Book</h3>
		<form action="MainServlet?action=addBook" method="POST">
	</c:if>
	<c:if test="${ !empty book }">	
		<h3>Edit Book</h3>
		<form action="MainServlet?action=updateBook" method="POST">
		<input type="hidden" name="id" value="${book.id}" />
	</c:if>
		
		Title : <input type="text" name="title" value="${book.title}" />
		Author : <input type="text" name="author" value="${book.author}" />
		Price : <input type="number" name="price" value="${book.price}" />
		<button type="submit">Submit</button>
	</form>
</body>
</html>