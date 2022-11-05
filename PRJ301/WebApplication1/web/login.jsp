<%-- 
    Document   : login
    Created on : May 27, 2022, 1:57:57 PM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST" style="margin:auto">
            <p>Username: <input type="text" name="username"></p>
            <p>Password: <input type="password" name="password"></p>
            <button name="submit">Login</button>
        </form>
    </body>
</html>
