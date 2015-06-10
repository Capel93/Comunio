<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2>Users List</h2>
    <ul>
    <c:if test="${not empty users}">
        <c:forEach var="user" items="${users}">
        <li><a href="/api/users/${user.getUsername()}">${user.getUsername()}</a></li>
        </c:forEach>
    </c:if>
    </ul>
    <p><a href="/api/users/userForm">NewUser</a></p>
</body>
</html>
