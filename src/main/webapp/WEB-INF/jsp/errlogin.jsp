<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Invalid Login</title>
</head>

<body style="background-color:pink;"> 
	<b>INVALID LOGIN: ${requestScope.showErr}</b>
	<br>
	<br>
	<a href="studlogin.htm">Go back to the login page</a>
</body> 

</html>