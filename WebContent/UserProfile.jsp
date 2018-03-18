<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form id="form3" action="UserProfileServlet" method="post" enctype="multipart/form-data" >
Photo <input type="file" name="image">
<br/>
<!--<form id="form4" action="UserProfileServlet" method="post">-->
Name <input type="text" id="nickName" name="nickName">
<br/>
University <input type="text" id="university" name="university">
<br/>
Gender <input type="radio" name="gender" value="female">Female 
	   <input type="radio" name="gender" value="male">Male
<br/>
BirthPlace
<select id="birthPlace" name="birthPlace">
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
Birthday
<select id="DateOfBirth_Month" name="DateOfBirth_Month">
<option>- Month -</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select> 
<select id="DateOfBirth_Day" name="DateOfBirth_Day">
<option>- Day -</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select> 
<select id="DateOfBirth_Year" name="DateOfBirth_Year">
<option>- Year -</option>
<option value="2011">2011</option>
<option value="2010">2010</option>
<option value="2009">2009</option>
<option value="2008">2008</option>
<option value="2007">2007</option>
<option value="2006">2006</option>
<option value="2005">2005</option>
<option value="2004">2004</option>
<option value="2003">2003</option>
<option value="2002">2002</option>
<option value="2001">2001</option>
<option value="2000">2000</option>
<option value="1999">1999</option>
<option value="1998">1998</option>
<option value="1997">1997</option>
<option value="1996">1996</option>
<option value="1995">1995</option>
<option value="1994">1994</option>
<option value="1993">1993</option>
<option value="1992">1992</option>
<option value="1991">1991</option>
<option value="1990">1990</option>
<option value="1989">1989</option>
<option value="1988">1988</option>
<option value="1987">1987</option>
<option value="1986">1986</option>
<option value="1985">1985</option>
<option value="1984">1984</option>
<option value="1983">1983</option>
<option value="1982">1982</option>
<option value="1981">1981</option>
<option value="1980">1980</option>
<option value="1979">1979</option>
<option value="1978">1978</option>
<option value="1977">1977</option>
<option value="1976">1976</option>
<option value="1975">1975</option>
<option value="1974">1974</option>
<option value="1973">1973</option>
<option value="1972">1972</option>
<option value="1971">1971</option>
<option value="1970">1970</option>
<option value="1969">1969</option>
<option value="1968">1968</option>
<option value="1967">1967</option>
<option value="1966">1966</option>
<option value="1965">1965</option>
<option value="1964">1964</option>
<option value="1963">1963</option>
<option value="1962">1962</option>
<option value="1961">1961</option>
<option value="1960">1960</option>
</select>
<br/>
About You <textarea id="introduction" cols="15" rows="10" name="introduction"></textarea>
<br/>
Expect Whom <textarea id="expectation" cols="15" rows="10" name="expectation"></textarea>
<br/>
<%-- <input type="submit" value="Submit"/>--%>
<input type="submit" value="Submit"/>

</form>

</body>
</html>