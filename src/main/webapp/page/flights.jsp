<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 20.01.2018
  Time: 15:24
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
    <title><fmt:message key="page.label.flights" bundle="${lang}"/></title>
    <link rel="stylesheet" href="page/loginCSS.css" media="screen" type="text/css"/>
    <link rel="stylesheet" href="page/flightsCSS.css" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="wrapper">
    <my:my/>
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                    <li><a href="main"><fmt:message key="page.label.homePage" bundle="${lang}"/></a></li>
                    <li class="current_page_item"><a href="#"><fmt:message key="page.label.flights" bundle="${lang}"/></a></li>
                    <li><a href="administrator"><fmt:message key="page.label.administrator" bundle="${lang}"/></a></li>
                    <li><a href="Controller?command=listCrew"><fmt:message key="page.label.dispatcher" bundle="${lang}"/></a></li>
                    <li><a href="login"><fmt:message key="page.label.login" bundle="${lang}"/></a></li>
                    <li><a href="registration"><fmt:message key="page.label.registration" bundle="${lang}"/></a></li>
                </form>
            </ul>
        </div>
    </div>
    <div>
        <div style="margin-bottom: 100px; margin-top: 50px; color: black " align="center">
            <h2><fmt:message key="flight.label.selectionByParams" bundle="${lang}"/></h2>
            <form action="Controller" name="command" method="post">
                <input type="hidden" name="command" value="sampleFlight">
                <select name="sortFlightBy">
                    <c:set var="sortFlight" value="${sortFlightBy}"/>
                    <c:if test="${sortFlight != null}">
                        <option><c:out value="${sortFlight}"/></option>
                    </c:if>
                    <option></option>
                    <c:choose>
                    <c:when test="${sortFlight != null}">
                        <c:choose>
                        <c:when test="${sortFlight eq 'Sort By Number'}">
                        </c:when>
                        <c:otherwise>
                            <option>S<fmt:message key="flight.label.sortByNumber" bundle="lang"/></option>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${sortFlight eq 'Sort By Name'}">
                            </c:when>
                            <c:otherwise>
                                <option><fmt:message key="flight.label.sortByName" bundle="lang"/></option>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <option><fmt:message key="flight.label.sortByNumber" bundle="lang"/> </option>
                        <option><fmt:message key="flight.label.sortByName" bundle="lang"/></option>
                    </c:otherwise>
                    </c:choose>
                </select>
                <select name="searchDepartureFlight">
                    <c:if test="${departureFlightChoice!=null}">
                        <c:set var="departureF" value="${departureFlightChoice}"/>
                    </c:if>
                    <c:if test="${departureF != null}">
                        <option><c:out value="${departureF}"/></option>
                    </c:if>
                    <option></option>
                    <c:forEach var="item" items="${airportList}">
                        <c:if test="${departureF ne item.name}">
                        <option><c:out value="${item.name}"/></option>
                        </c:if>
                    </c:forEach>
                </select>
                <select name="searchLandingFlight">
                    <c:if test="${landingFlightChoice!=null}">
                        <c:set var="landingF" value="${landingFlightChoice}"/>
                    </c:if>
                    <c:if test="${landingF != null}">
                        <option><c:out value="${landingF}"/></option>
                    </c:if>
                    <option></option>
                    <c:forEach var="item" items="${airportList}">
                        <c:if test="${landingF ne item.name}">
                            <option><c:out value="${item.name}"/></option>
                        </c:if>
                    </c:forEach>
                </select>
                <c:choose>
                <c:when test="${departureDateChoice!=null}">
                <input type="date" name="date" value="${departureDateChoice}">
                </c:when>
                <c:otherwise>
                    <input type="date" name="date">
                </c:otherwise>
                </c:choose>
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
            <th><fmt:message key="flight.label.number" bundle="${lang}"/></th>
            <th><fmt:message key="flight.label.plane" bundle="${lang}"/> </th>
            <th><fmt:message key="flight.label.from" bundle="${lang}"/> </th>
            <th><fmt:message key="flight.label.departureTime" bundle="${lang}"/></th>
            <th><fmt:message key="flight.label.to" bundle="${lang}"/> </th>
            <th><fmt:message key="flight.label.landgingTime" bundle="${lang}"/></th>
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
