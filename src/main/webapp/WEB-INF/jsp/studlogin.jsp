<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Student Lgn Page</title>
	</head>
	<body style="background-color:azure;margin-left:30%;margin-top:50px;margin-right:40%;"> 
	<div style="background:MediumTurquoise;padding:20px;">
		<form action="main.htm" method="POST"> 
		<b>LOGIN CREDENTALS</b></td>
		<br>
		<br>
		<table>
			<tr>
				<td>Student EmailID:</td> 
				<td><input type="text" name="eid"/></td>
			</tr>
			<tr>
				<td>Passsword:</td> 
				<td><input type="password" name="passwd"/></td>
			</tr>
			<tr>
			<td></td>
				<td><input type="submit" value="Login"/></td>
			</tr>
		</table>
		</form>
		</div>
	</body> 
</html>