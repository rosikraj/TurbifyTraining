<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
tr,td {
  border: 1px solid black;
  border-radius: 10px;
}
tr:hover {background-color: white;}
div {
        		width: 1200px;
        		overflow: hidden;

        		clear: both;
      		}
      		p{
        		margin-bottom: 10px;
      		}
      		input.right {
        	float: right;
      		}
</style>
<script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>
</head>
<body bgcolor="Bisque">
<table align='center'>

<b><% Integer uid=(Integer)session.getAttribute("uid"); %></b>
AccountID:<%=uid %>

<div>
<form action="button.html">
<input type="submit" value="Logout" class="right">
</form>
</div>
<tr>
<td><h1><center>To withdraw:</center></h1></td>
<td><a href="Withdraw.jsp">Click here</a></td>
</tr>
<tr>
<td><h1><center>To deposit:</center></h1></td>
<td><a href="Deposit.jsp">Click here</a></td>
</tr>
<tr>
<td><h1><center>Fund Transfer:</center></h1></td>
<td><a href="FundTransfer.jsp">Click here</a></td>
</tr>
<tr>
<td><h1><center>Show Balance:</center></h1></td>
<td><a href='Balance.jsp'>Click here</a></td>
</tr>
<tr>

</tr>
</table>
</body>
</html>