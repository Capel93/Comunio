<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 21/05/15
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>TeamSquad</title>
</head>
<body>
    <p><a href="/api/teamSquads">TeamSquad</a></p>
    <c:if test="${not empty teamSquad}">
        <h2>Greeting number ${teamSquad.getName()}</h2>
        <p>Message: ${fn:escapeXml(teamSquad.getContent())}
            (<a href="/api/teamSquads/${teamSquad.getId()}/">edit</a>)</p>
        <p>By ${teamSquad.getManager().getUserName()} </p>


    </c:if>
</body>
</html>
