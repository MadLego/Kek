<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 20.01.2018
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Flights</title>
    <link rel="stylesheet" href="page/loginCSS.css" media="screen" type="text/css"/>
    <link rel="stylesheet" href="page/flightsCSS.css" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                    <li><a href="main">Homepage</a></li>
                    <li class="current_page_item"><a href="#">Flights</a></li>
                    <li><a href="administrator">Administrator</a></li>
                    <li><a href="Controller?command=listCrew">Dispatcher</a></li>
                    <li><a href="login">Login</a></li>
                    <li><a href="registration">Registration</a></li>
                </form>
            </ul>
        </div>
    </div>
    <div>
        <div style="margin-bottom: 100px; margin-top: 50px; color: black " align="center">
            <h2>Flight selection by parameter</h2>
            <form action="Controller" name="command" method="post">
                <input type="hidden" name="command" value="sampleFlight">
                <select name="sortFlightBy">
                    <option></option>
                    <option>Sort By Number</option>
                    <option>Sort By Name</option>
                </select>
                <select name="searchDepartureFlight">
                    <option></option>
                    <c:forEach var="item" items="${airportList}">
                        <option><c:out value="${item.name}"/></option>
                    </c:forEach>
                </select>
                <select name="searchLandingFlight">
                    <option></option>
                    <c:forEach var="item" items="${airportList}">
                        <option><c:out value="${item.name}"/></option>
                    </c:forEach>
                </select>
                <input type="date" name="date">
                <input type="submit" value="Sort" name="Submit">
            </form>
        </div>
    </div>
<c:choose>
    <c:when test="${searchList!=null}">
        <c:set var="i" value="${searchList}"/>
    </c:when>
    <c:otherwise>
        <c:set var="i" value="${flightList}"/>
    </c:otherwise>
</c:choose>
    <table class="simple-little-table" cellspacing='0'>
        <tr>
            <th>Flight Number</th>
            <th>Plane</th>
            <th>From</th>
            <th>Departure Time</th>
            <th>To</th>
            <th>Landing Time</th>
        </tr><!-- Table Header -->
        <c:forEach var="item" items="${i}">
            <tr>
                <td><c:out value="${item.number}"/></td>
                <td><c:out value="${item.plane}"/></td>
                <td><c:out value="${item.departure_airport}"/></td>
                <td><c:out value="${item.departure_time}"/></td>
                <td><c:out value="${item.landing_airport}"/></td>
                <td><c:out value="${item.landing_time}"/></td>
            </tr>
            <!-- Table Row -->
        </c:forEach>
    </table>

</div>
</div>
<!-- end #footer -->
</body>
</html>
