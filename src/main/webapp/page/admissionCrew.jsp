<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 29.01.2018
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dispetcher</title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css" />
    <link rel="stylesheet" href="limk.css" media="screen" type="text/css" />
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
                <th>Pilot </th>
                <th>Navigator </th>
                <th>Radio Operator </th>
                <th>First Stewardess </th>
                <th>Second Stewardess </th>
                <th>Status</th>
                <th>Apply</th>
            </tr><!-- Table Header -->
            <c:forEach var="item" items="${views}">
            <tr>
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="acceptCrew">
                    <td><input type="hidden" name="flightId" value="${item.flightId}"><c:out value="${item.flightId}"/></td>
                    <td><c:out value="${item.pilot}"/></td>
                    <td><c:out value="${item.navigator}"/></td>
                    <td><c:out value="${item.radioOperator}"/></td>
                    <td><c:out value="${item.firstConductor}"/></td>
                    <td><c:out value="${item.secondConductor}"/></td>
                    <td>
                        <select name="admission">
                            <option value="Ok">Accept</option>
                            <option value="No">Reject</option>
                        </select>
                    </td>
                    <td><input type="submit" value="Submit"></td>
                </form>
            </tr><!-- Table Row -->
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

