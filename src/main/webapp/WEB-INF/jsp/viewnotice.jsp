<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noticeboard</title>
    </head>
    <body style="background-color:pink;">
        <table border="1" >
            <tr>
            	<td><b>NOTICE ID</b></td>
            	<td><b>STUDENT ID</b></td>
                <td><b>TITLE</b></td>
                <td><b>INFORMATION</b></td>
            </tr>
            <c:forEach var="n" items="${Notices}">
                <tr>
                	<td>${n.nid}</td>
                	<td>${n.sid.eid}</td>
                    <td>${n.title}</td>
                    <td>${n.cnt}</td>                                
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="main.htm">Navigate to Home page</a>
    </body>
</html>