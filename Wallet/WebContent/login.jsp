<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>
</head>
<body bgcolor="Bisque">
	<center>
		<form method="post" action="LoginServlet">
			AccountID:<input type="number" name="uid"><br>
			<br> Password:<input type="password" name="password"><br>
			<br> <input type="submit" value="Login">
		</form>
	<button onclick="window.close()">Exit</button>
	
</body>
</html>