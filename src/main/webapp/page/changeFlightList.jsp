<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 21.01.2018
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.label.administrator" bundle="${lang}"/></title>
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
                    <%@ include file="/page/JSPF/administrator(Empty).jspf"%>
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
                <th><fmt:message key="flight.label.changeFlight" bundle="${lang}"/></th>
            </tr><!-- Table Header -->

            <c:forEach var="item" items="${flightList}">
                <form action="Controller?command=changeThisFlight" method="post">
                    <tr>
                        <td><input type="hidden" name="name" value="${item.number}"><c:out value="${item.number}"/></td>
                        <td><input type="hidden" name="plane" value="${item.plane}"><c:out value="${item.plane}"/></td>
                        <td><input type="hidden" name="departure_airport" value="${item.departure_airport}"><c:out value="${item.departure_airport}"/></td>
                        <td><input type="hidden" name="departure_time" value="${item.departure_time}"><c:out value="${item.departure_time}"/></td>
                        <td><input type="hidden" name="landing_airport" value="${item.landing_airport}"><c:out value="${item.landing_airport}"/></td>
                        <td><input type="hidden" name="landing_time" value="${item.landing_time}"><c:out value="${item.landing_time}"/></td>
                        <td><input type="submit" value="<fmt:message key="flight.label.changeFlight" bundle="${lang}"/>"></td>
                    </tr><!-- Table Row -->
                </form>
            </c:forEach>


        </table>
    </div>
</div>
<!-- end #footer -->
</body>
</html>
