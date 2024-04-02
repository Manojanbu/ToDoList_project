<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet" href="login.css"> 
</head>
<body>
<div id="div">
	<h1>Login</h1>
	<div id=mydiv>
	<form action="login" method="post">
	<label>Email : </label>
	<input type="email" name="email" class="in">
	<br>
	<br>
	<label>Password : </label>
	<input type="password" name="pass" class="in">
	<br>
	<br>
	<button id="bt">submit</button>
	</form>
	</div>
</div>
</body>
</html>