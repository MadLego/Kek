<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.label.flights" bundle="${lang}"/></title>
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
                    <c:choose>
                        <c:when test="${userRoleName eq 'admin'}">
                            <%@ include file="/page/JSPF/search(Admin).jspf"%>
                        </c:when>
                        <c:when test="${userRoleName eq 'dispatcher'}">
                            <%@ include file="/page/JSPF/search(Dispatcher).jspf"%>
                        </c:when>
                        <c:otherwise>
                            <%@ include file="/page/JSPF/search(Empty).jspf"%>
                        </c:otherwise>
                    </c:choose>
                </form>
            </ul>
        </div>
    </div>
    <div>
        <c:choose>
        <c:when test="${searchingFlight != null}">
        <table class="simple-little-table" cellspacing='0'>

            <tr>
                <th><fmt:message key="flight.label.number" bundle="${lang}"/></th>
                <th><fmt:message key="flight.label.plane" bundle="${lang}"/> </th>
                <th><fmt:message key="flight.label.from" bundle="${lang}"/> </th>
                <th><fmt:message key="flight.label.departureTime" bundle="${lang}"/></th>
                <th><fmt:message key="flight.label.to" bundle="${lang}"/> </th>
                <th><fmt:message key="flight.label.landgingTime" bundle="${lang}"/></th>
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

