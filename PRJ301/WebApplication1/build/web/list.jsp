<%-- 
    Document   : list
    Created on : Jun 10, 2022, 1:26:39 PM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <th>Account</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Address</th>
                <th>Birthday</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.getUsername()}</td>
                    <td>${user.getFullName()}</td>
                    <td>${user.getAddress()}</td>
                    <td>${user.getGender() ? "Female" : "Male"}</td>
                    <td>${user.getDob()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
