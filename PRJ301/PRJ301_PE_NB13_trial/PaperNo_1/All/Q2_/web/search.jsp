<%-- 
    Document   : search
    Created on : Jul 11, 2022, 1:27:21 PM
    Author     : manhn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>sid</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>dob</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.sid}</td>
                        <td>${student.name}</td>
                        <td>${student.gender}</td>
                        <td>${student.dob}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
