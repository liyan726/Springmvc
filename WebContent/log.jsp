<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<font color="red" size="+2">${err.mesName}</font>
	<form action="/Springmvc/log">
	
	username:<input name="name" type="text"/>
	
	<input type="submit" value="Login">
	</form>
</body>
</html>