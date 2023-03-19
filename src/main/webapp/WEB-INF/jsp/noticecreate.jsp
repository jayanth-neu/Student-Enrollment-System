<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
	    <title>Create Notice Form</title>
	</head>
	<body style="background-color:pink;">
		<h2>University Updates</h2>
		<form:form modelAttribute="notice" method="post">
			<table>
				<tr>
				    <td>Category:</td>
				    <td><form:input path="title" size="30" /></td>
				</tr>
				<tr>
				    <td>Information:</td>
				    <td><form:textarea path = "cnt" rows = "10" cols = "30" /></td>
				</tr>
				<tr>
				    <td colspan="2"><input type="submit" value="Create Notice" /></td>
				</tr>
			</table>
		</form:form>
		<br>
		<a href="main.htm">Navigate to Home page</a>
	</body>
</html>