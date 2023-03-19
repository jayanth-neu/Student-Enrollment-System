<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
	    <title>Delete Notice Form</title>
	</head>
	<body style="background-color:pink;">
		<h2>Delete Notice from NoticeBoard</h2>
		<form:form modelAttribute="notice" method="post">
			<table>
				<tr>
				    <td>NoticeID</td>
				    <td><form:input path="nid" size="30" /></td>
				</tr>
				<tr>
				    <td colspan="2"><input type="submit" value="Delete Notice" /></td>
				</tr>
			</table>
		</form:form>
		<br>
		<br>
		<a href="main.htm">Navigate to Home page</a>
	</body>
</html>