<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
 <h2>Fund Transfer</h2>
 <form action="fundtransfer" method="post">
 Recipient Account: <input type="text" name="recipientAccount"><br>
 Amount to Transfer: <input type="number" name="transferAccount"><br>
 <input type="submit" value="Transfer">
 </form>
</body>
</html>