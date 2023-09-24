<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import = "java.sql.ResultSet"%>
<%@page import="com.infinite.wallet.Database" %>
<%int uid =(Integer) session.getAttribute("uid");
ResultSet rs = null;
ResultSet result = null;
Connection conn =null; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Bisque">
<table style="width:100%">
<tr>
<td>
<center><h2>AccountID: <%= uid %></h2></center>
</td>
</tr>
<tr>
<td>
<center>
<h2>Available Balance:
<%

try
{
	//Class.forName("com.mysql.jdbc.Driver");
	conn=Database.getMyconnection("mysql");

	PreparedStatement ps = conn.prepareStatement("select balance from accounts where accountID=?");
	ps.setInt(1, uid);
	rs = ps.executeQuery();
	if(rs.next())
	{
		float balance = rs.getFloat("balance");
		out.println("Rs."+balance);
	}
	}
	catch(SQLException e){
		System.out.println(e);
	}
	
	catch(IllegalStateException e){
		System.out.println(e);
	}
	finally {
		try 
		{
			//conn.close();
			System.out.println("Connection closed");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
						%>
						 </h2></center>
</td>
</tr>
<tr>
<td>
<center>
<form action="main.jsp">
<input type="submit" value="OK"></form></center>
</td>
</tr>
</table>
</body>
</html>