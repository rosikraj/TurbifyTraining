<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="background-color:#a0daa0;">
<center>
<h1>Login Page</h1>
<br><br>
<br><br>
		<form method="post" action="login">
			<br>
			<br> UserName <input type="text" name="username"> <br>
			<br> Password <input type="password" name="password"> <br>			
			<br> <input type="submit" value="Login">&nbsp &nbsp  <input type="reset" value="Reset"><br><br>
		</form>
		 <form method="post" action ="register">
		 <input type="submit" value="Register"></form>
	</center>
	<form action="logout" method="post">
<input type="submit" value="Logout"><br>
</form>
</body>
</html>