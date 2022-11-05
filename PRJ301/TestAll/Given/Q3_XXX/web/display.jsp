<%-- 
    Document   : display
    Created on : Dec 11, 2019, 8:42:50 AM
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
        <ul>
            <c:forEach items="${data}" var="q">
                <li>${q.getContent()}
                    <ul>
                        <c:forEach items="${q.getAnswers()}" var="a">
                            <li>${a.getContent()}</li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
