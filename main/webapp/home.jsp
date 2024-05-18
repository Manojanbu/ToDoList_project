<%@page import="DTO.Task"%>
<%@page import="java.util.List"%>
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
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td, th {
	border: 1px solid black;
	padding: 10px 40px;
}

th {
	background-color: plum;
}

body {
	background-image:
		url("https://img.freepik.com/free-vector/abstract-background-with-colorful-shape_361591-3929.jpg?w=1380");
	background-repeat: no-repeat;
	background-size: 100%;
	font-family: sans-serif;
}

#details {
	position: absolute;
	left: 300px;
	top: 30px
}

#add {
	text-decoration: none;
	position: absolute;
	right: 20px;
	top: 40px;
	margin-right: 10px;
	border: 2px solid black;
	padding: 15px 30px;
	border-radius: 35px;
	font-family: sans-serif;
	background-color: white;
	font-weight: bold;
	/* display:none; */
}

#add:hover {
	background-color: black;
	color: white;
	border: 2px solid white;
}

#logout {
	text-decoration: none;
	position: absolute;
	right: 20px;
	top: 100px;
	margin-right: 10px;
	border: 2px solid black;
	padding: 15px 35px;
	border-radius: 35px;
	font-family: sans-serif;
	background-color: white;
	font-weight: bold;
}

#logout:hover {
	background-color: black;
	color: white;
	border: 2px solid white;
}

#img {
	position: absolute;
	left: 30px;
	top: 30px;
	border-radius: 50px;
}

#form {
	position: absolute;
	top: 220px;
	left: 250px;
}

#slide1 {
	border: 2px solid black;
	margin-left: 97%;
	text-align: center;
	padding: 2px 2px;
	border-radius: 3px;
}
</style>

</head>
<body>
	<div id="slide1">
		<i class="fa-solid fa-bars"></i>
	</div>
	<div id="details">
		<%HttpSession ses=request.getSession(); %>
		<%User u=(User)ses.getAttribute("user"); %>
		<h1>
			Hello
			<%=u.getUsername() %></h1>
		<h1>
			Email:
			<%=u.getUseremail() %></h1>
		<h1>
			Contact:
			<%=u.getUsercontact() %></h1>
	</div>
	<%String image=new String(Base64.getEncoder().encode(u.getUserimage())); %>
	<div id="img">
		<img src="data:image/jpeg;base64,<%=image %>" height="200px"
			width="200px">
	</div>
	<a href="addtask.jsp" id="add">Add task</a>
	<a href="logout" id="logout">Logout</a>

	<%List<Task> task=(List)request.getAttribute("tasks"); %>
	<div id="form">
		<h1>Tasks</h1>
		<table>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Priority</th>
				<th>Deu Date</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
			<%int num=1; %>
			<%for(Task tasks:task) {%>
			<tr>
				<td><%= num++%></td>
				<td><%= tasks.getTasktitle()%></td>
				<td><%= tasks.getTaskdescription()%></td>
				<td><%= tasks.getTaskpriority()%></td>
				<td><%= tasks.getTaskduedate()%></td>
				<td><%= tasks.getTaskstatus()%></td>
				<td><a href="delete?taskid=<%=tasks.getTaskid()%>">Delete</a></td>
				<td><a href="edit?taskid=<%=tasks.getTaskid()%>">Edit</a></td>
			</tr>
			<%} %>
		</table>
	</div>
	<script src="https://kit.fontawesome.com/95907a0af4.js"
		crossorigin="anonymous"></script>
	<script src="home.js"></script>
</body>
</html>