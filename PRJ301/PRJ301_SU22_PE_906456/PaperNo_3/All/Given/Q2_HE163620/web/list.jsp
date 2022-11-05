<%-- 
    Document   : list.jsp
    Created on : Jul 16, 2022, 8:02:23 AM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Added book by ${account.name}</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Added Date</th>
                    <th>Is Online</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.addedAt}</td>
                        <td>${book.onlineString}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
