<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <body style="background-color:pink;">
        <table border="2">
            <tr>
            	<td><b>STUDENT ID</b></td>
                <td><b>STUDENT EMAILID</b></td>
                <td><b>STUDENT FNAME</b></td>
                <td><b>STUDENT LNAME</b></td>
                <td><b>STUDENT ADMIN</b></td>
            </tr>
            <c:forEach var="stud" items="${StudList}">
                <tr>
                	<td>${stud.sid}</td>
                	<td>${stud.eid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>                
                    <td>${stud.adminstu}</td>                
                </tr>
            </c:forEach>
        </table><br>
        <a href="main.htm">Navigate to Home page</a>
    </body>
</html>