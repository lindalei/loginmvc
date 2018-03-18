<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.mvc.dao.ShowUsersDao" %>
<%@ page import="java.io.*" %>
      <%@ page import="com.mvc.bean.UserProfileBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
<title>Insert title here</title>
 <script type="text/javascript">
    function del(){
    		if(confirm("Do You Want to Delete Your Profile?"))
    		{
    		}
    		else
    		{
    		return false;
    		}
    }
    </script>
</head>
<body>
<%
	
    String id = request.getParameter("id");
	System.out.println("pass id is:"+id);
	ShowUsersDao userDao = new ShowUsersDao();
    UserProfileBean user = userDao.getUserById(Integer.parseInt(id));
    pageContext.setAttribute("user", user);
    
    Integer userid = (Integer)request.getSession(false).getAttribute("userID");
    
  
%>
   
<div class='user'>
    <div class='nickName'>${user.nickName}</div>
    <div class='image'><img src ='${user.filePath}'></div>
    <div class='university'>${user.nickName}</div>
 	<div class='introduction'>${user.introduction}</div>
    <div class='expectation'>${user.expectation}</div>
</div>
<c:set var = "id" value="<%=id %>"></c:set>
<c:set var = "userid" value='<%=userid.toString() %>'></c:set>
<% System.out.println(id+userid);%>
<c:if test="${id == userid}">
<div align="center"><a href="editProfile.jsp?userId=<%=id%>">Edit</a></div>
<div align="center"><a href="ShowUsers.jsp?delete_profile=yes&userId=<%=id%>" onclick="return del()">Delete</a></div>
</c:if>
</body>
</html>