<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <%@ page import="com.mvc.dao.UserProfileDao" %>
      <%@ page import="com.mvc.bean.UserProfileBean" %>
      <%@ page import="java.util.*" %>
      <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>

 <%--
 <script>
 window.onunload = refreshParent;
  function refreshParent() {
    window.opener.location.reload();
  }
  function closeSelf(){
    document.forms["form3"].submit(function(){ window.close();});
     
  }
</script>
 --%>
</head>
<body>
<% 
String userId=request.getParameter("userId");
String nickName =null;
String image =null;
String university =null;
String gender =null;
String introduction =null;
String expectation =null;
String birthPlace =null;
String month =null;
String day =null;
String year =null;
if(userId != null){
	int UserID = Integer.parseInt(userId);
	UserProfileDao user = new UserProfileDao();
	UserProfileBean userBean = new UserProfileBean();
	userBean = user.editProfile(UserID);
	nickName= userBean.getNickName();
	image = userBean.getFilePath();
	university = userBean.getUniversity();
	gender = userBean.getGender();
	birthPlace = userBean.getBirthPlace();
	//request.setAttribute("birthPlace", birthPlace);
	introduction = userBean.getIntroduction();
	expectation = userBean.getExpectation();
	String date =userBean.getBirthday().toString();
	String[] parts = date.split("-");
	year = parts[0];
	month = parts[1];
	day = parts[2];
	System.out.println("date:"+date);
	System.out.println("month:"+month);
	System.out.println("day:"+day);
	System.out.println("image:"+image);
	System.out.println(nickName+image+university+gender+birthPlace+introduction+expectation+month+day+year);
}

String[] places={"上海","江苏","浙江","广东","北京","天津","河北","陕西","山西","山东","河南","安徽","内蒙","新疆","广西","云南","西藏","辽宁","吉林","黑龙江","甘肃","贵州","四川","海南","福建","湖北","湖南","青海","重庆"};
int [] months ={1,2,3,4,5,6,7,8,9,10,11,12};
int[] days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
int [] years ={2007,1999,1998,1997,1996,1995,1994,1993,1992,1991,1990,1989,1988,1987,1986,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,1975,1974,1973,1972,1971};
%>
<form id="form" action="UpdateUserProfileServlet" method="post" enctype="multipart/form-data" >
Photo <input type="file" name="image"> <img src ='<%= image%>'>
<br/>
<!--<form id="form4" action="UserProfileServlet" method="post">-->
Name <input type="text" id="nickName" name="nickName" value="<%=nickName %>">
<br/>
University <input type="text" id="university" name="university" value="<%=university%>">
<br/>
Gender
<c:set var = "gender" value="<%=gender %>"></c:set>
<c:choose>
<c:when test="${gender == 'female'}">
        <input type="radio" name="gender" value="female" checked="checked">Female 
        <input type="radio" name="gender" value="male">Male
        </c:when>
        <c:otherwise>
        <input type="radio" name="gender" value="female">
 		<input type="radio" name="gender" value="male" checked="checked">Male
 		</c:otherwise>
 		</c:choose>
<br/>
BirthPlace
<select name="birthPlace">
 <c:set var = "birthPlace" value="<%=birthPlace %>"></c:set>
 <c:set var = "places" value="<%=places %>"></c:set>
    <c:forEach var="item" items="${places}">
  <c:choose>
    <c:when test="${item.equals(birthPlace)}">
        <option value="${item}" selected='selected'>${item}</option>
    </c:when>
    <c:otherwise>      
    	<option value="${item}">${item}</option>
    	</c:otherwise> 
 </c:choose>
    </c:forEach>
</select>

<br/>
Birthday
<select name="DateOfBirth_Month">
<c:set var = "month" value="<%=Integer.parseInt(month) %>"></c:set>
<c:set var = "months" value="<%=months %>"></c:set>
    <c:forEach var="item" items="${months}">
    <c:choose>
    <c:when test="${item.equals(month)}">
        <option value="${item}" selected='selected'>${item}</option>
    </c:when>
    <c:otherwise>
    	<option value="${item}">${item}</option>
    </c:otherwise>
    </c:choose>>
    </c:forEach>
</select>
<select name="DateOfBirth_Day">
<c:set var = "day" value="<%=Integer.parseInt(day) %>"></c:set>
<c:set var = "days" value="<%=days %>"></c:set>
    <c:forEach var="item" items="${days}">
    <c:choose>
    <c:when test="${item.equals(day)}">
        <option value="${item}" selected='selected'>${item}</option>
    </c:when>
    <c:otherwise>
    	<option value="${item}">${item}</option>
    </c:otherwise>
    </c:choose>>
    </c:forEach>
</select>
<select name="DateOfBirth_Year">
<c:set var = "year" value="<%=Integer.parseInt(year) %>"></c:set>
<c:set var = "years" value="<%=years %>"></c:set>
    <c:forEach var="item" items="${years}">
    <c:choose>
    <c:when test="${item.equals(year)}">
        <option value="${item}" selected='selected'>${item}</option>
    </c:when>
    <c:otherwise>
    	<option value="${item}">${item}</option>
    </c:otherwise>
    </c:choose>>
    </c:forEach>
</select>
<br/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>