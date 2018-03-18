<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
</head>
<body>
<form id="filter" action="FilterServlet" method="post">
Gender <input type="radio" id="genderfemale" name="Gender" value="female">Female <br/>
	   <input type="radio" id="gendermale" name="Gender" value="male">Male
<br/>
BirthPlace
<select id="Birthplace" name="Birthplace">
<option></option>
<option value="1">上海</option>
<option value="2">江苏</option>
<option value="3">浙江</option>
<option value="4">广东</option>
<option value="5">北京</option>
<option value="6">天津</option>
<option value="7">河北</option>
<option value="8">陕西</option>
<option value="9">山西</option>
<option value="10">山东</option>
<option value="11">河南</option>
<option value="12">安徽</option>
<option value="13">内蒙</option>
<option value="14">新疆</option>
<option value="15">广西</option>
<option value="16">云南</option>
<option value="17">西藏</option>
<option value="18">辽宁</option>
<option value="19">吉林</option>
<option value="20">黑龙江</option>
<option value="21">甘肃</option>
<option value="22">贵州</option>
<option value="23">四川</option>
<option value="24">海南</option>
<option value="25">福建</option>
<option value="26">湖北</option>
<option value="27">湖南</option>
<option value="28">青海</option>
<option value="29">重庆</option>
</select>
<br/>
<input type="submit" value="Apply Filters"/>
</form>
</body>
</html>