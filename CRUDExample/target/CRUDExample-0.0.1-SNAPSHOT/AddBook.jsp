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

	<h3>Add Book</h3>
	<form action="MainServlet?action=addBook" method="POST">
		Title : <input type="text" name="title" />
		Author : <input type="text" name="author" />
		Price : <input type="number" value="0" name="price" />
		<button type="submit">Submit</button>
	</form>
</body>
</html>