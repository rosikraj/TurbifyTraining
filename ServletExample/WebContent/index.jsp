<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome....</title>
</head>
<body>
<form action="Right_Vote_or_Not" method="get"/ >
name: <input type="text" name="name" placeholder="Name"/> <br>
age:  <input type="number" name="age" placeholder="number"/> <br>
<input type="submit" placeholder="submit"/>
<%
String s = this.getServletName();
out.println(s);

%>
</body>
</html>