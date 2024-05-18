<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="Stylesheet" href="Signup.css">
</head>
<body>

	<div id="div">
		<h1>Signup</h1>
		<div id="mydiv">

			<form action="SaveUser" enctype="multipart/form-data" method="post">
				<!-- <label class="lb">Id :</label>
		<input type="number" name="id" class="in"> <br> <br> <br>-->
				<label class="lb">Name :</label> <input type="text" name="name"
					class="in"> <br> <br> <br> <label
					class="lb">Email:</label> <input type="email" name="email"
					class="in"> <br> <br> <br> <label
					class="lb">Contact:</label> <input type="number" name="contact"
					class="in"> <br> <br> <br> <label
					class="lb">Password :</label> <input type="password" name="pass"
					class="in"> <br> <br> <label class="lb">Image
					: </label> <input type="file" name="image" class="in"> <br> <br>
				<button>submit</button>

			</form>
		</div>
	</div>
</body>
</html>