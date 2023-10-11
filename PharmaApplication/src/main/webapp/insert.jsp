<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert details</title>
</head>
<body>
<form method="post" action="insert">
medicinename <input type="text" name="medicine" placeholder="medicinename"/><br>
expiry_date <input type="date" name="expiredate" placeholder="expiry_date"/><br>
Cost <input type="number" name="cost" placeholder="Cost"/><br>
quantity <input type="number" name="quantity" placeholder="quantity"/> <br>
codeno <input type="number" name="codeno" placeholder="codeno"/><br>
<input type="submit" value="insert"/>
</body>
</html>