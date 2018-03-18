<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action="RegisterServlet" method="post">
<table align="center">
<tr>
<td>Full Name</td>
<td><input type="text" name="fullName"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email" /></td>
</tr>
<tr>
<td>UserName</td>
<td><input type="text" name="userName" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="text" name="conpassword" /></td>
</tr>
<tr>
<td><%=(request.getAttribute("errMsg") == null)? "": request.getAttribute("errMsg")%></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Register"></input></td>
</tr>
</table>
</form>
</body>
</html>