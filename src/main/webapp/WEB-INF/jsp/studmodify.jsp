<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Modify Student Form</title>
	</head>
	
	<body style="background-color:pink;"> 
		<form action="modifystud.htm" method="POST"> 
		<table>
			<tr>
				<td>To be Updated Student EmailID:</td>
				<td><input type="text" name="eid"/></td>
			</tr>
			<tr>
				<td>Change EmailID?</td> 
				<td><input type="radio" name="eidchange" value="Yes">Yes <input type="radio" name="eidchange" value="No" checked>No</td>
			</tr>
			<tr>
				<td>Updated EmailID:</td> 
				<td><input type="text" name="changedeid"/></td>
			</tr>
			<tr>
				<td>Change Admin Access?</td> 
				<td><input type="radio" name="adminstuchange" value="Yes">Yes <input type="radio" name="adminstuchange" value="No" checked>No</td>
			</tr>
			<tr>
				<td>Updated Student Type:</td> 
				<td><input type="radio" name="changedadminstu" value="Admin">Admin <input type="radio" name="changedadminstu" value="Student" checked>Student</td>
			</tr>
			<tr>
				<td>Change First Name?</td> 
				<td><input type="radio" name="firstnamechange" value="Yes">Yes <input type="radio" name="firstnamechange" value="No" checked>No</td>
			</tr>
			<tr>
				<td>Updated First Name:</td> 
				<td><input type="text" name="changedfirstname"/></td>
			</tr>
			<tr>
				<td>Change Last Name?</td>  
				<td><input type="radio" name="lastnamechange" value="Yes">Yes <input type="radio" name="lastnamechange" value="No" checked>No</td> 
			</tr>
			<tr>
				<td>Updated Last Name:</td>
				<td><input type="text" name="changedlastname"/></td>
			</tr>
			<tr>
				<td>Change Password?</td> 
				<td><input type="radio" name="passwdchange" value="Yes">Yes <input type="radio" name="passwdchange" value="No" checked>No</td>
			</tr>
			<tr>
				<td>Updated Password:</td> 
				<td><input type="password" name="changedpasswd"/></td>
			</tr>
		</table>
		<input type="submit" value="Modify Student"/>
		<br>
		<br>
		<a href="main.htm">Navigate to Home page</a>
		</form>
	</body> 
</html>