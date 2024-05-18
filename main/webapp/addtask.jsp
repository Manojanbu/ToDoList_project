<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add task</title>
<link rel="stylesheet" href="addtask.css">
</head>
<body>
	<form action="displaytask" method="post">
		<!-- <label class="lb">Id     :</label><input type="text" name="taskid" id="in1"> <br> -->
		<label class="lb">Title :</label><input type="text" name="tasktitle"
			id="in2"><br> <label class="lb">Description: </label><input
			type="text" name="taskdescription"><br> <label>Priority:</label><br>
		<input type="radio" name="taskpriority" value="low"> Low<br>
		<input type="radio" name="taskpriority" value="medium"> Medium<br>
		<input type="radio" name="taskpriority" value="high"> High<br>
		<label>Due Date:</label><input type="date" name=taskduedate><br>


		<button id="bt">submit</button>

	</form>
</body>
</html>