<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	int uid = (Integer) session.getAttribute("uid");
	float at = (float) session.getAttribute("at");
	float bal = (float) session.getAttribute("bal");
	int faid = (Integer) session.getAttribute("faid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer Receipt</title>
<style>
td, th, tr, table {
	border: 1px solid black;
	border-collapse: collapse;
}
th{
padding-top: 12px;
  padding-bottom: 12px;}

@media print {
    .hidden-print,
    .hidden-print * {
        display: none !important;
    }
}
</style>
</head>
<body bgcolor="Bisque">
	<center>
	<h1><b>Withdrawal Receipt</b></h1>
		<table>
			<tr>
				<th class="aid">AccountID</th><th></th>
				<th class="at">Amount Transfered</th><th></th>
				<th class="bm">Balance Amount</th><th></th>
				<th class="faid">Tranfered to</th><th></th>
			</tr>
			<tr>
				<td class="aid"><%=uid%></td><td></td>
				<td class="at"><%=at%></td><td></td>
				<td class="bm"><%=bal%></td><td></td>
				<td class="faid"><%=faid%></td><td></td>
			</tr>
		</table>
		<button onclick="window.print()" >print</button>
		<button onclick="window.close()">close</button>
		<script src="script.js"></script>
		<form action="main.jsp">
		<input type="submit" value="Go to home">
		</form>
	</center>
</body>
</html>
