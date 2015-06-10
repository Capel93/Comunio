<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 21/05/15
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title></title>
</head>
<body>
  <h2>TeamSquad List</h2>
  <ul>
    <c:if test="${not empty teamSquads}">
      <c:forEach var="teamSquad" items="${teamSquads}">
        <li><a href="/api/teamSquads/${teamSquad.getId()}">${teamSquad.getName()}</a></li>
      </c:forEach>
    </c:if>
  </ul>
  <p><a href="/api/teamSquads/teamSquadForm/Test">Add</a></p>

</body>
</html>
