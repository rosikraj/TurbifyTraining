<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<h2>Create Account</h2>
<form action="createAccount" method="post">
Account Holder Name: <input type="text" name="accountHolderName"><br>
Initial Balance:<input type="number" name="initialBalance"><br>
<input type="submit" value="Create Account">
</form>
</body>
</html>