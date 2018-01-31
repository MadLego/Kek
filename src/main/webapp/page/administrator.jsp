<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 22:17
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
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />

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
                    <li><a href="Controller?command=listFlight"><fmt:message key="page.label.flights" bundle="${lang}"/></a></li>
                    <li class="current_page_item"><a href="#"><fmt:message key="page.label.administrator" bundle="${lang}"/></a></li>
                    <li><a href="Controller?command=listCrew"><fmt:message key="page.label.dispatcher" bundle="${lang}"/></a></li>
                    <li><a href="login"><fmt:message key="page.label.login" bundle="${lang}"/></a></li>
                    <li><a href="registration"><fmt:message key="page.label.registration" bundle="${lang}"/></a></li>
                </form>
            </ul>
        </div>
    </div>
    <div align="center">
        <a href="Controller?command=prepareFlight" class="button7"><fmt:message key="administrator.label.newFlight" bundle="${lang}"/></a></br>
        <a href="Controller?command=listFlightForChange" class="button7"><fmt:message key="administrator.label.changeFlight" bundle="${lang}"/></a></br>
        <a href="Controller?command=listFlightForDelete" class="button7"><fmt:message key="administrator.label.deleteFlight" bundle="${lang}"/></a></br>
        <a href="Controller?command=prepareEmployee" class="button7"><fmt:message key="administrator.label.newEmployee" bundle="${lang}"/></a></br>
        <a href="Controller?command=listEmployeeForChange" class="button7"><fmt:message key="administrator.label.changeEmployee" bundle="${lang}"/></a></br>
        <a href="Controller?command=listEmployeeForDelete" class="button7"><fmt:message key="administrator.label.deleteEmployee" bundle="${lang}"/></a></br>
        <a href="Controller?command=listCrewAccept" class="button7"><fmt:message key="administrator.label.checkCrew" bundle="${lang}"/></a></br>
    </div>
</div>
</body>
</html>
