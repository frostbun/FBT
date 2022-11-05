<%-- 
    Document   : index
    Created on : Jun 20, 2022, 1:31:23 PM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <th>IDStudent</th>
                <th>Fullname</th>
                <th>Gender</th>
            </tr>
            <c:forEach items="${list}" var="student">
                <tr>
                    <td>${student.getIDStudent()}</td>
                    <td>${student.getName()}</td>
                    <td>${student.isGender() ? "Male" : "Female"}</td>
                    <td> 
                        <form action="./delete" method="post">
                            <input type="hidden" value="${student.getIDStudent()}" name="id">
                            <button name="submit">Delete</button>
                        </form> 
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="./insert" method="post">
            Fullname: <input type="text" name="name"> <br>
            <select name="gender">Gender: 
                <option value="0">Male</option>
                <option value="1">Female</option>
            </select> <br>
            <button name="submit">Submit</button>
        </form>
        <p>${error}</p>
    </body>
</html>
