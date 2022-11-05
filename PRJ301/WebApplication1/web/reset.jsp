<%-- 
    Document   : reset
    Created on : Jun 6, 2022, 1:50:43 PM
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
        <form action="reset" method="post">
            <label for="username">Account</label>
            <input type="text" name="username" id="username" required> <br>
            <label for="dob">Birthdate</label>
            <input type="text" name="dob" id="dob" required> <br>
            ${result}
            <button name="submit">Submit</button> <br>
        </form>
        <label for="password">New password</label>
        <input type="text" name="password" id="password" value="${password}">
    </body>
</html>
