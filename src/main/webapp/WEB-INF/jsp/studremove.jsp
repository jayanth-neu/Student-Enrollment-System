<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
	    <title>Delete Student Form</title>
	</head>
	<body style="background-color:pink;">
		<h2>Delete Student</h2>
		<form:form modelAttribute="student" method="post">
			<table>
			<tr>
			    <td>Student Email ID:</td>
			    <td><form:input path="eid" size="30" /></td>
			</tr>
			<tr>
			    <td colspan="2"><input type="submit" value="Delete Student" /></td>
			</tr>
			</table>
		</form:form>
		<br>
		<br>
		<a href="main.htm">Navigate to Home page</a>
	</body>
</html>