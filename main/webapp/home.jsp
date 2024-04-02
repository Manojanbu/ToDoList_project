<%@page import="java.util.Base64"%>
<%@page import="DTO.User"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="home.css">
<style>
#img{
	position:absolute;
	top:10px;
	left:30px;

}
h1
{
	margin-left:250px;
}
</style>
</head>
<body>

	<%HttpSession ses=request.getSession(); %>
	<%User u=(User)ses.getAttribute("user"); %>
	<h1>Hello :<%=u.getUsername() %></h1>
	<h1>Email: <%=u.getUseremail() %></h1>
	<h1>Contact: <%=u.getUsercontact() %></h1>
	<%String image=new String(Base64.getEncoder().encode(u.getUserimage())); %>
<div id="img">	<img  src="data:image/jpeg;base64,<%=image %>" height="200px" width="200px"></div>
</body>
</html>