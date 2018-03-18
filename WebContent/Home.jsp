<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="submit.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Linda Page</h2>
</center>
<% 
System.out.println("Homepage session: "+request.getSession(false));
   if(session!= null){
     if(session.getAttribute("userName")!=null){%>
   <form name="logout" action="LogoutServlet" method="post">
   <div style="text-align: right;">
   <input type="submit" value="Logout">
   </div>
	   <div style="text-align: right;">
	   <h3>Welcome  <%= request.getSession().getAttribute("userName") %></h3>
	   </div>
	   </form>
   <%}
   else{%>
   <form name="login" action="Login.jsp" method="post">
	   <div style="text-align: right;">
	    <input type="submit" value="Login">
	    </div>
	    </form>
	   <%-- <input type="button" value="Login" onclick="javascript:window.location='Login.jsp'"> %>--%>
	   
   <%}
   }
%>

<%--<div style="text-align: left; diaplay:inline;">
<ul class="tags" style="list-style-type: none;">
 <li><a href="ShowUsersServlet" class="tablinks">Home</a></li>
	<li><a href="UserProfile.jsp" class="tablinks">About U</a></li>
	<li><a href="Filter.jsp" class="tablinks">Filter</a></li>
	<li><a href="test.jsp" class="tablinks">Test</a></li>
</ul>
</div>
--%>
<a href="ShowUsersServlet" class="tablinks">Home</a> 
<a onclick="PopupCenterDual('UserProfileValidateServlet','Profile','600','550');" href="javascript:void(0);">Profile</a>
<a onclick="PopupCenterDual('Filter.jsp','Filter','500','450');" href="javascript:void(0);">Filter</a>
<%-- <a href="javascript:window.open('UserProfile.jsp', 'Profile', 'width=500,height=450');" class="tablinks">Profile</a> 
<a href="javascript:window.open('Filter.jsp', 'Filter', 'width=500,height=450');" class="tablinks">Filter</a> 
--%> 
<form name="search" action="SearchUsersServlet" method="post">
<input type="text" id="search" name="search">
<input type="submit" value="Search">
</form>

</body>
</html>