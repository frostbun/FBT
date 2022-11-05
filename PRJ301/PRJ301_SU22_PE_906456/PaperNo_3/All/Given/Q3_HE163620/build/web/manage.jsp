<%-- 
    Document   : manage
    Created on : Jul 16, 2022, 8:26:53 AM
    Author     : manhn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <td></td>
                    <c:forEach items="${categories}" var="category">
                        <td>${category.name}</td>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${applications}" var="application">
                    <tr>
                        <td>${application.name}</td>
                        <c:forEach items="${categories}" var="category">
                            <td>${category.getApllications().get(application)}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
