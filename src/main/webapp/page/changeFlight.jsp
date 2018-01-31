<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 19.01.2018
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator</title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />

</head>
<body>

<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul class="menu">
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
                <th>Change</th>
            </tr><!-- Table Header -->

            <form action="Controller?command=changeFlight" method="post">
                <tr>
                    <c:forEach var="item" items="${changeThisList}">
                    <td><input type="text" size="20"
                               pattern="([A-Z0-9]){3,6}"
                               minlength="3"
                               maxlength="6"
                               name="name"
                               value="${item.name}"
                               placeholder="Enter Flight Number"/>
                        <span class="validity"></span></td>
                    <td><select autofocus="" name="plane" required>
                        <c:set var="plane" value="${item.plane}"/>
                        <option><c:out value="${plane}"/></option>
                        <c:forEach var="i" items="${flightList}">
                            <c:if test="${plane != i.plane}">
                            <option><c:out value="${i.plane}"/></option>
                            </c:if>
                        </c:forEach>
                    </select></td>
                        <c:set var="departure_airport" value="${item.departure_airport}"/>
                    <td><select autofocus="" name="departure_airport" required>
                        <option><c:out value="${departure_airport}"/></option>
                        <c:forEach var="i" items="${airportList}">
                            <c:if test="${i.name != departure_airport}">
                            <option><c:out value="${i.name}"/></option>
                            </c:if>
                        </c:forEach>
                    </select>

                    </td>

                    <td><input type="datetime-local" name="departure_time" value="${item.departure_time_out}"/></td>
                    <td>
                        <c:set var="landing_airport" value="${item.landing_airport}"/>
                        <select autofocus="" name="landing_airport" required>
                            <option><c:out value="${landing_airport}"/></option>
                            <c:forEach var="i" items="${airportList}">
                                <c:if test="${i.name != landing_airport}">-->
                                <option><c:out value="${i.name}"/></option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="datetime-local" name="landing_time" value="${item.landing_time_out}" required/></td>
                    <td>
                        <input type="submit" value="Submit"/>
                    </td>
                    </c:forEach>
                </tr><!-- Table Row -->
            </form><!-- Table Row -->
        </table>
        <c:forEach var="item" items="${errors}">
            <p style="color: red" align="center"><c:out value="${item}"/></p>
        </c:forEach>
    </div>
</div>
<!-- end #footer -->
</body>
