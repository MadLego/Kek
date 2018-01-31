<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Flights</title>
    <link rel="stylesheet" href="page/loginCSS.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="page/flightsCSS.css" type="text/css"  />
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                    <li><a href="main">Homepage</a></li>
                    <li><a href="Controller?command=listFlight">Flights</a></li>
                    <li><a href="administrator">Administrator</a></li>
                    <li><a href="Controller?command=listCrew">Dispatcher</a></li>
                    <li><a href="login">Login</a></li>
                    <li><a href="registration">Registration</a></li>
                </form>
            </ul>
        </div>
    </div>
    <div>
        <c:choose>
        <c:when test="${searchingFlight != null}">
        <table class="simple-little-table" cellspacing='0'>

            <tr>
                <th>Flight Number </th>
                <th>Plane </th>
                <th>From </th>
                <th>Departure Time </th>
                <th>To </th>
                <th>Landing Time</th>
            </tr><!-- Table Header -->
            <c:forEach var="searchingFlight" items="${searchingFlight}">
                <tr>
                    <td><c:out value="${searchingFlight.number}"/></td>
                    <td><c:out value="${searchingFlight.plane}"/></td>
                    <td><c:out value="${searchingFlight.departure_airport}"/></td>
                    <td><c:out value="${searchingFlight.departure_time}"/></td>
                    <td><c:out value="${searchingFlight.landing_airport}"/></td>
                    <td><c:out value="${searchingFlight.landing_time}"/></td>
                </tr><!-- Table Row -->
            </c:forEach>
        </table>
        </c:when>
            <c:otherwise>
               <p style="color: red"  align="center"><c:out value="${errors}"/></p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<!-- end #footer -->
</body>
</html>

