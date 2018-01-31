<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 29.01.2018
  Time: 17:27
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
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.label.administrator" bundle="${lang}"/></title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css" />
    <link rel="stylesheet" href="limk.css" media="screen" type="text/css" />
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
                    <td><input type="submit" value="Submit"></td>
                </form>
            </tr><!-- Table Row -->
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

