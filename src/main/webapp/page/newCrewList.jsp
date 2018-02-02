<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 27.01.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/language.tld" prefix="mytag"%>
<%@ taglib prefix="my" uri="mytaglib.tld" %>
<script type="text/javascript">
    function insertParam(key, value) {
        key = encodeURIComponent(key); value = encodeURIComponent(value);

        var kvp = document.location.search.substr(1).split('&');
        if (kvp == '') {
            document.location.search = '?' + key + '=' + value;
        }
        else {

            var i = kvp.length; var x; while (i--) {
                x = kvp[i].split('=');

                if (x[0] == key) {
                    x[1] = value;
                    kvp[i] = x.join('=');
                    break;
                }
            }

            if (i < 0) { kvp[kvp.length] = [key, value].join('='); }

            //this will reload the page, it's likely better to store this until finished
            document.location.search = kvp.join('&');
        }
    }
</script>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="FlightBundle" var="lang" />
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.label.dispatcher" bundle="${lang}"/></title>
    <link rel="stylesheet" href="page/loginCSS.css" media="screen" type="text/css" />
    <link rel="stylesheet" href="page/flightsCSS.css" type="text/css"  />
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />
</head>
<body>
<my:my/>
<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                    <li><a href="main"><fmt:message key="page.label.homePage" bundle="${lang}"/></a></li>
                    <li><a href="Controller?command=listFlight"><fmt:message key="page.label.flights" bundle="${lang}"/></a></li>
                    <li><a href="administrator"><fmt:message key="page.label.administrator" bundle="${lang}"/></a></li>
                    <li><a href="Controller?command=listCrew"><fmt:message key="page.label.dispatcher" bundle="${lang}"/></a></li>
                    <li><a href="login"><fmt:message key="page.label.login" bundle="${lang}"/></a></li>
                    <li><a href="registration"><fmt:message key="page.label.registration" bundle="${lang}"/></a></li>
                </form>
            </ul>
        </div>
    </div>
    <div>
        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th><fmt:message key="flight.label.number" bundle="${lang}"/></th>
                <th><fmt:message key="flight.label.plane" bundle="${lang}"/> </th>
                <th><fmt:message key="flight.label.from" bundle="${lang}"/> </th>
                <th><fmt:message key="flight.label.departureTime" bundle="${lang}"/></th>
                <th><fmt:message key="flight.label.to" bundle="${lang}"/> </th>
                <th><fmt:message key="flight.label.landgingTime" bundle="${lang}"/></th>
                <th>This</th>
            </tr><!-- Table Header -->

            <c:forEach var="item" items="${flightList}">
                <form action="Controller" method="post">
                    <tr>
                        <input type="hidden" name="flightId" value="${item.id}">
                        <td><input type="hidden" name="name" value="${item.number}"><c:out value="${item.number}"/></td>
                        <td><c:out value="${item.plane}"/></td>
                        <td><c:out value="${item.departure_airport}"/></td>
                        <td><input type="hidden" name="departure_time" value="${item.departure_time}"><c:out value="${item.departure_time}"/></td>
                        <td><c:out value="${item.landing_airport}"/></td>
                        <td><input type="hidden" type="hidden" name="landing_time" value="${item.landing_time}"><c:out value="${item.landing_time}"/></td>
                        <td><input type="submit" name="command" value="<fmt:message key="label.view.new" bundle="${lang}"/>"></td>
                    </tr><!-- Table Row -->
                </form>
            </c:forEach>
        </table>
    </div>
</div>
<!-- end #footer -->
</body>
</html>
