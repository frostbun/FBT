<%-- 
    Document   : display
    Created on : Dec 9, 2019, 3:18:55 PM
    Author     : sonnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500"></canvas>
        <script>
            function toX(x)
            {
                return 50 + (x*3);
            }
            function toY(y)
            {
                return 350 - (y*3);
            }
    
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            ctx.beginPath();
            ctx.moveTo(50, 50);
            ctx.lineTo(50, 350);
            ctx.lineTo(350, 350);
            ctx.stroke();
            
            ctx.beginPath();
            ctx.moveTo(45, 53);
            ctx.lineTo(50, 50);
            ctx.lineTo(55, 53);
            ctx.stroke();
            
            ctx.beginPath();
            ctx.moveTo(345, 345);
            ctx.lineTo(350, 350);
            ctx.lineTo(345, 355);
            ctx.stroke();
            
            ctx.font = "12px Arial";
            ctx.fillText("(0,0)", 30, 355);
            
            ctx.font = "12px Arial";
            ctx.fillText("(0,100)", 10, 50);
            
            ctx.font = "12px Arial";
            ctx.fillText("(100,0)", 355, 355);
            <c:forEach items="${requestScope.data}" var="p">
                ctx.beginPath();
                ctx.arc(toX(${p.x})-5, toY(${p.y})-5, 5, 0, 2 * Math.PI);
                ctx.fillStyle = "red";
                ctx.fill();
                ctx.stroke();
                ctx.fillStyle = "black";
                ctx.font = "12px Arial";
                ctx.fillText("("+toX(${p.x})+","+toY(${p.y})+")", toX(${p.x})-10, toY(${p.y})-10);
            </c:forEach>
        </script>
    </body>
</html>
