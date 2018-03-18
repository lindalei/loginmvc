<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
    <c:forEach items="${usersFiltered}" var="userFiltered">
        <tr>
            <td>${userFiltered.nickName}</td>
            <td><c:out value="${userFiltered.university}" /></td>
            <td><c:out value="${userFiltered.gender}" /></td>
            <td><c:out value="${userFiltered.birthPlace}" /></td>
            <td><c:out value="${userFiltered.birthday}" /></td>
            <td><c:out value="${userFiltered.introduction}" /></td>
            <td><c:out value="${userFiltered.expectation}" /></td>      
        </tr>
    </c:forEach>
</table>
</body>
</html>