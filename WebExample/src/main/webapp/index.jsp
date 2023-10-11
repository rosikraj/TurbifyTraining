<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<<div align="center">
<h2>Spring MVC Login Form</h2>
<table border="0" width="30%">
<form:form action="login" commandName="userForm">
<tr>
<td align="left" width="20%">Email-Id</td>
<td align="left" width="20%"><form:input path="email" size="30"/></td>
<td align="left"><form:errors path="email" cssClass="error"/></td>
</tr>
<tr>
<td>Password </td>
<td><form:password path="password" size="30"/></td>
<td><form:errors path="password" cssClass="error"/></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="submit" value="Login"/></td>
<td></td>
</tr>
</form:form>

</table>
</div>
</form>
</body>
</html>
