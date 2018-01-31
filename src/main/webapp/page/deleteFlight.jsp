<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 21.01.2018
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <input type="button" onclick="javascript:set()">
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
        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>Flight Number </th>
                <th>Plane </th>
                <th>From </th>
                <th>Departure Time </th>
                <th>To </th>
                <th>Landing Time</th>
                <th>Delete Flight</th>
            </tr><!-- Table Header -->

            <c:forEach var="item" items="${flightList}">
                <form action="Controller?command=deleteFlight" method="post">
                <tr>
                    <td><input type="hidden" name="name" value="${item.number}"><c:out value="${item.number}"/></td>
                    <td><c:out value="${item.plane}"/></td>
                    <td><c:out value="${item.departure_airport}"/></td>
                    <td><c:out value="${item.departure_time}"/></td>
                    <td><c:out value="${item.landing_airport}"/></td>
                    <td><c:out value="${item.landing_time}"/></td>
                    <td><input type="submit" value="Delete"></td>
                </tr><!-- Table Row -->
                </form>
            </c:forEach>


        </table>
    </div>
</div>
<!-- end #footer -->
</body>
</html>

