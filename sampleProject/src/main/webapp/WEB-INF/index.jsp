<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot Day 1</title>
</head>
<body>
<h1>The Joke Site</h1>
<form method="POST" action="/addJoke">
<p>Name: <input type="text" name="name"></p>
<p>Joke: <input type="text" name="joke"></p>
<button>Add Joke!</button>
</form>

</body>
</html>