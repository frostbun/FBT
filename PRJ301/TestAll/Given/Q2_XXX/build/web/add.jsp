<%-- 
    Document   : add
    Created on : Jun 29, 2022, 1:46:53 PM
    Author     : manhn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<h1>Add new Student</h1>
<form method="post">
    ID: <input type="number" name="id" required> <br>
    Name: <input type="text" name="name" required> <br>
    Gender: <input type="radio" name="gender" value="male" required>Male
    <input type="radio" name="gender" value="female">Female <br>
    Department: <select name="did" required>
        <c:forEach items="${departments}" var="d">
            <option value="${d.getId()}">${d.getName()}</option>
        </c:forEach>
    </select> <br>
    <p>${error}</p>
    <button name="submit">Add</button>
</form>
