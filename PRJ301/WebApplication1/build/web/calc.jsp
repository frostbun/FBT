<%-- 
    Document   : calc
    Created on : May 27, 2022, 1:18:42 PM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calc</title>
    </head>
    <body>
        <h1>Cal</h1>
        <form action="Calc" method="post">
            <p>Enter A: <input type="number" name="a" value='${a}' required></p>
            <p>Enter B: <input type="number" name="b" value='${b}' required></p>
            <p>Result: <input value='${result}'disabled></p>
            <button name="submit" value="gcd">GCD</button>
            <button name="submit" value="lcm">LCM</button>
        </form>
    </body>
</html>
