<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
	    <title>Create Student Form</title>
	</head>
	<body style="background-color:pink;">
		<h2>Enroll New Student</h2>
		<form:form modelAttribute="student" method="post">
			<table>
				<tr>
				    <td>Student Type:</td>
				    <td><form:radiobutton path="adminstu" value="true"/>Admin Student <form:radiobutton path="adminstu" value="false"/>General Student</td>
				</tr>
				<tr>
				    <td>Student FName:</td>
				    <td><form:input path="firstname" size="40" /></td>
				</tr>
				<tr>
				    <td>Student LName:</td>
				    <td><form:input path="lastname" size="40" /></td>
				</tr>
				<tr>
				    <td>Student Email ID:</td>
				    <td><form:input path="eid" size="40" /></td>
				</tr>
				<tr>
				    <td>Password:</td>
				    <td><form:password path="passwd" size="40" /></td>
				</tr>
				<tr>
				    <td colspan="2"><input type="submit" value="Create Student" /></td>
				</tr>
			</table>
		</form:form>
		<br>
		<br>
		<a href="main.htm">Navigate to Home page</a>
	</body>
</html>