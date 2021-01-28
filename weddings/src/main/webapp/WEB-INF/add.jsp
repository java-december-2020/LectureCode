<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Wedding</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
  crossorigin="anonymous">
</head>
<body>
<div class="container">
  <form:form action="/weddings/new" method="post" modelAttribute="wedding">
    <form:input type="hidden" value="${ user_id }" path="planner" />

    <div class="form-group">
          <form:label path="wedderOne">Bride Name</form:label>
          <form:errors path="wedderOne"/>
          <form:input class="form-control" path="wedderOne" />
      </div>
      <div class="form-group">
          <form:label path="wedderTwo">Groom Name</form:label>
          <form:errors path="wedderTwo"/>
          <form:input class="form-control" path="wedderTwo" />
      </div>
      <div class="form-group">
          <form:label path="date">Date</form:label>
          <form:errors path="date"/>
          <form:input type="date" class="form-control" path="date" />
      </div>
      <div class="form-group">
          <form:label path="address">Address</form:label>
          <form:errors path="address"/>
          <form:input class="form-control" path="address" />
      </div>
      <button>Submit</button>
  </form:form>
</div>
</body>
</html>