<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please enter the train details</title>
</head>
<body style="background-color: #a0daa0;">
	<center>
		<h1>Welcome to Train Information Application</h1>
		<h3> Search your train details here</h3>
		<div style="text-align: right;">

			<button>
				<a href="https://www.irctc.co.in/nget/">Ticket Booking</a>
			</button>
		</div>
		<br>
		<form action="info" method="post">
			<br> TrainID <input type="number" name="TrainId"> <br>
			<input type="submit" value="Search"><br>
			<br>
		</form>
		<form action="details" method="post">
			Source<select name="source">
				<option value="">-Select-</option>
				<option value="Warangal">Warangal</option>
				<option value="kmm">khammam</option>
				<option value="vizag">vizag</option>
				<option value="Hyderabad">Hyderabad</option>
			</select><br> <br> Destination<select name="destination">
				<option value="">-Select-</option>
				<option value="Warangal">Warangal</option>
				<option value="kmm">khammam</option>
				<option value="vizag">vizag</option>
				<option value="Hyderabad">Hyderabad</option>
			</select><br> <br> <input type="submit" value="Get Train Details" />
		</form>
	</center>
</body>
</html>