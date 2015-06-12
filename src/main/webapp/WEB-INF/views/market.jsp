<%--
  Created by IntelliJ IDEA.
  User: joanmarc
  Date: 12/06/15
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<html>
<head>
  <title>Comunio</title>
  <link rel="stylesheet" href="/css/application.css">


</head>
<body>
<div id="main">
  <div id="header">
    <div id="banner">
      <div id="welcome">
        <h1>${user.username}</h1>
      </div><!--close welcome-->
      <div id="welcome_slogan">
        <h1>Comunio, by UdL</h1>
      </div><!--close welcome_slogan-->
    </div><!--close banner-->
  </div><!--close header-->

  <div id="menubar">
    <ul id="menu">
      <li class="current"><a href="/mainPage">Home</a></li>
      <li><a href="/users">Ranking</a></li>
      <li><a href="/teamSquads">currentRunking</a></li>
      <li><a href="/teamSquad/${user.teamSquad}">teamSquad</a></li>
      <li><a href="/market/${user.username}">Market</a></li>
    </ul>
  </div><!--close menubar-->

  <div id="site_content">

    <div id="content">
      <div class="content_item">
        <div class="well">

            <span id="user">

                    <ul id="myList">Team
                      <c:form action="/teamSquads/players" method="post" >

                      <c:forEach var="player" items="${players}">
                          <li><input type="checkbox" name="teamPlayers" value="${player.getNick()}">${player.getNick()} - ${player.getPrice()} - ${player.getTeam()}</li>
                      </c:forEach>
                      <input type="submit" value="Submit">
                      </c:form>
                    </ul>
                    <div id="ShowPlayers">Show players</div>
                    <div id="HidePlayers">Hide Players</div>

            </span>
        </div>

      </div><!--close content_item-->
    </div><!--close content-->
  </div><!--close site_content-->



</div><!--close main-->

<div id="footer">
  <a href="http://validator.w3.org/check?uri=referer">Valid XHTML</a> | <a href="http://fotogrph.com/">Images</a> | <a href="http://www.heartinternet.co.uk/vps/">Virtual Server</a> | website template by <a href="http://www.araynordesign.co.uk">ARaynorDesign</a>
</div><!--close footer-->
</body>
</html>
