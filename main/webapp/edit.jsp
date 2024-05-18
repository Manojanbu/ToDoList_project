<%@page import="DTO.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" href="edit.css">
</head>
<body>
	<%Task tasks=(Task)request.getAttribute("task"); %>

	<form action="updatetask" method="post">
		<input type="text" hidden="" name="taskid" id="in1"
			value="<%=tasks.getTaskid()%>"> <br> <label class="lb">Title
			:</label><input type="text" name="title" value="<%= tasks.getTasktitle()%>"
			id="in2"><br> <label class="lb">Description: </label><input
			type="text" name="description"
			value="<%= tasks.getTaskdescription()%>"><br> <label>Priority:</label><br>
		<input type="radio" name="priority" value="low"> Low<br>
		<input type="radio" name="priority" value="medium"> Medium<br>
		<input type="radio" name="priority" value="high"> High<br>
		<label>Due Date:</label><input type="date" name="duedate"
			value="<%= tasks.getTaskduedate()%>"><br> <label>status:</label><input
			type="text" name="status" value="<%= tasks.getTaskstatus()%>">
		<input type="number" name="userid" hidden=""
			value="<%=tasks.getUserId() %>">
		<button id="bt">submit</button>

	</form>

</body>
</html>