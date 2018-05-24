<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 27.01.2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
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
                    <c:choose>
                        <c:when test="${userRoleName eq 'dispatcher'}">
                            <%@ include file="/page/JSPF/crew.jspf"%>
                        </c:when>
                        <c:otherwise>
                            <%@ include file="/page/JSPF/crew.jspf"%>
                        </c:otherwise>
                    </c:choose>
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
                    <input type="hidden" name="command" value="newThisCrew">
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
