<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 19.01.2018
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.label.administrator" bundle="${lang}"/></title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />

</head>
<body>
<my:my/>
<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul class="menu">
                <form action="Controller" name="command" method="post">
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

            <form action="Controller?command=changeFlight" method="post">
                <tr>
                    <c:forEach var="item" items="${changeThisList}">
                    <td><input type="text" size="20"
                               pattern="([A-Z0-9]){3,6}"
                               minlength="3"
                               maxlength="6"
                               name="name"
                               value="${item.name}"
                               placeholder="<fmt:message key="label.hint.enterFlightNumber" bundle="${lang}"/>"/>
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
                        <input type="submit" value="<fmt:message key="flight.label.submit" bundle="${lang}"/>"/>
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
