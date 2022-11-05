<%-- 
    Document   : student
    Created on : Jun 29, 2022, 1:48:00 PM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td, tr {
            border: 1px solid black;
        }
    </style>
    <body>
        <c:if test="${skip == null}">
            <c:import url="add.jsp"></c:import>
        </c:if>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Department</th>
            </tr>
            <c:forEach items="${students}" var="s">
                <tr>
                    <td>${s.getId()}</td>
                    <td>${s.getName()}</td>
                    <td>${s.isGender() ? "Male" : "Female"}</td>
                    <td>${s.getdName()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
