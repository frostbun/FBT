<%-- 
    Document   : product
    Created on : Jun 22, 2022, 1:41:03 PM
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
        <c:forEach begin="${1}" end="${lastPage}" var="i">
            <a href="?page=${i}">${i}</a>            
        </c:forEach>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Unit</th>
                <th>Price</th>
                <th>Image</th>
            </tr>
            <c:forEach items="${list}" var="product">
                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getName()}</td>
                    <td>${product.getUnit()}</td>
                    <td>${product.getPrice()}</td>
                    <td><image width="200" src="${product.getImage()}"></td>
                    <td><a href="update?id=${product.getId()}">Update</a></td>
                    <td><a href="delete?id=${product.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
