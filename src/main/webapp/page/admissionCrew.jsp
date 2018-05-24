<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 29.01.2018
  Time: 17:27
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

<div id="wrapper">
    <my:my/>
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul class="menu">
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
                <th><fmt:message key="crewAdmission.label.pilot" bundle="${lang}"/></th>
                <th><fmt:message key="crewAdmission.label.navigator" bundle="${lang}"/> </th>
                <th><fmt:message key="crewAdmission.label.radioOperator" bundle="${lang}"/></th>
                <th><fmt:message key="crewAdmission.label.firstStewardess" bundle="${lang}"/></th>
                <th><fmt:message key="crewAdmission.label.secondStewardess" bundle="${lang}"/></th>
                <th><fmt:message key="crewAdmission.label.status" bundle="${lang}"/></th>
                <th><fmt:message key="crewAdmission.label.apply" bundle="${lang}"/></th>
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
                    <td><input type="submit" value="<fmt:message key="flight.label.submit" bundle="${lang}"/>"></td>
                </form>
            </tr><!-- Table Row -->
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

