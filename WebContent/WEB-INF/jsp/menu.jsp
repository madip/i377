<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Part 5</title>
<style type="text/css">
<%@ include file ="/style.css"%>
</style>
</head>
<body>
	<ul id="menu">
		<li><a href="<c:url value='/search' />" id="menu_Search">Otsi</a></li>
		<li><a href="<c:url value='/addForm' />" id="menu_Add">Lisa</a></li>
		<li><a href="<c:url value='/admin/clearData' />"
			id="menu_ClearData">Tühjenda</a></li>

	</ul>
	<br>
	<br>
	<br>
</body>
</html>