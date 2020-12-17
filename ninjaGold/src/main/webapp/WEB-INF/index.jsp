<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold!</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
<p>Your Gold: <c:out value="${totalGold}"/></p>

<div class="box">
<h3>Farm</h3>
<p>Finds 10-20 Gold</p>
<form method="POST" action="/addGold">
<input type="hidden" name="building" value="farm">
<button>Find Gold</button>
</form>
</div>

<div class="box">
<h3>Cave</h3>
<p>Finds 5-10 Gold</p>
<form method="POST" action="/addGold">
<input type="hidden" name="building" value="cave">
<button>Find Gold</button>
</form>
</div>

<div class="box">
<h3>House</h3>
<p>Finds 2-5 Gold</p>
<form method="POST" action="/addGold">
<input type="hidden" name="building" value="house">
<button>Find Gold</button>
</form>
</div>

<div class="box">
<h3>Casino</h3>
<p>Find / Lose up to 50 gold!</p>
<form method="POST" action="/addGold">
<input type="hidden" name="building" value="casino">
<button>Find Gold</button>
</form>
</div>

<h2>Activities</h2>
<div class="activities">
<c:forEach items="${activityLog }" var="act">
<p class='${act.contains("lost")? "red" : "green" }'><c:out value="${act}"/></p>
</c:forEach>
</div>
</div>
</body>
</html>