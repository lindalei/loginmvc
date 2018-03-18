<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ page import="com.mvc.dao.UserProfileDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
   <script>
    function detail(id){
    var a = document.createElement("a");
    a.href = "UserDetails.jsp?id=" + id; 
    console.log(a);
    a.target = '_new'; //指定在新窗口打开
    a.click();//触发打开事件
}
    </script>
<title>Insert title here</title>
</head>
<body>
<% 
  String delete_profile = request.getParameter("delete_profile");
  String id = request.getParameter("userId");
	UserProfileDao userDelete = new UserProfileDao();
    if(id!=null){
    	if("yes".equals(delete_profile)){
    		userDelete.deleteProfile(Integer.parseInt(id));
    	}
    }
%>
<table>
    <c:forEach items="${users}" var="user">
   <%--      <tr>
            
            <td><img src = "${user.filePath}" ></td>  
            <td> <a href ="${user.id}" >${user.nickName}</a></td>     
        </tr> 
           <td><c:out value="${user.filePath}" /></td>
            <td><iframe src="images/flower1.jpg" style="width: 200; height: 200"></iframe></td> 
            <td><c:out value="${user.university}" /></td>
            <td><c:out value="${user.gender}" /></td>
            <td><c:out value="${user.birthPlace}" /></td>
            <td><c:out value="${user.birthday}" /></td>
            <td><c:out value="${user.introduction}" /></td>
            <td><c:out value="${user.expectation}" /></td>  --%>   
       <li class='user' onclick="detail(${user.id});">
              
             <%--        <div class='nickName'>${user.nickName}</div>
                    <div class='image'><img src = "${user.filePath}"></div>                                   
            --%>
                       
            <span><img src = "${user.filePath}" width="300px" height = "400px"></span>  
            <span> ${user.nickName}</span> 
            </li>
          
             
       
    </c:forEach>
 
</table>
</body>
</html>