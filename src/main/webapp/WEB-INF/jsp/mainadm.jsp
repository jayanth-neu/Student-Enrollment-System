<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
                <style>
          nav {
    flex-direction: column;
  }
  nav ul {
    flex-direction: column;
    padding-top: 0.5rem;
  }
  nav li {
    padding: 0.5rem 0;
  }

        </style>
    </head>
    
    <body style="background-color:pink;">
     <nav>
		<h2>MENU</h2>
		<ul> 
         <li>   <a href="studlist.htm">Student List</a>
		</li> 
         <li>   <a href="createstud.htm">Create Student</a>
		</li> 
         <li>   <a href="modifystud.htm">Modify Student</a>
		</li> 
         <li>   <a href="removestud.htm">Remove Student</a>
		</li> 
         <li>   <a href="createnotice.htm">Create Notice</a>
		</li> 
         <li>   <a href="listnotice.htm">Notice Board</a>
		<br> 
         <li>   <a href="removenotice.htm">Remove Notice</a>
		</li> 
         <li>   <a href="studlgout.htm">Logout</a>
       </li>   
       </ul>      
       </nav>
         <br>         
		<b>Welcome ${sessionScope.studlogin.firstname}, ${sessionScope.studlogin.lastname}</b>
    </body>
    
</html>
