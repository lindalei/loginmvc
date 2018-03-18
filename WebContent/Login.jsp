<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action="LoginServlet" method="post">
<table align="center">
<tr>
<td>UserName</td>
<td><input type="text" name="userName" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>
<%--<tr>
<td><%=(request.getAttribute("errMsg") == null)? "": request.getAttribute("errMsg")%></td>
</tr>
--%>
<tr>
<td></td>
<td><input type="submit" value="Login"></input></td>
</tr>
</table>
</form>
</body>
</html>