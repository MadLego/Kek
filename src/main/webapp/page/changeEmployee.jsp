<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 18.01.2018
  Time: 23:06
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
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css"/>

</head>
<body>
<my:my/>
<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul class="menu">
                <form action="Controller" name="command" method="post">
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
                <th><fmt:message key="employee.label.firstName" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.lstName" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.age" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.permission" bundle="${lang}"/>n</th>
                <th><fmt:message key="employee.label.role" bundle="${lang}"/></th>
            </tr>

        <form action="Controller?command=changeEmployee" method="post">
            <tr>
            <c:forEach var="item" items="${changeThisEmployee}">
                <td style="display:none;"><input type="hidden" name="id" value="${item.id}"></td>
                <td><input type="text" placeholder="<fmt:message key="employee.label.firstName" bundle="lang"/>"
                pattern="([A-Z]{1}[a-z]+)"
                name="name" value="${item.firstName}" required/>
                    <span class="validity"/></td>
                <td><input type="text" placeholder="<fmt:message key="employee.label.lstName" bundle="lang"/>"
                pattern="([A-Z]{1}[a-z]+)"
                name="surName" value="${item.lastName}"required/>
                    <span class="validity"/></td>
                <td><input type="number"
                           min="18" step="1" name="age" value="${item.age}" required/>
                    <span class="validity"></span></td>
                </td>
                <td><select name="admission">
                    <option><fmt:message key="label.vew.true" bundle="lang"/></option>
                    <option><fmt:message key="label.vew.false" bundle="lang"/></option>
                </select></td>
                <td><select name="role">
                <c:forEach var="i" items="${roleList}">
                    <option><c:out value="${i}"/></option>
                </c:forEach>
                </select></td>
                <td>
                        <input type="submit" name="change" value="<fmt:message key="flight.label.changeFlight" bundle="${lang}"/>"/>
                </td>
            </c:forEach>
            </tr>
        </form>
        </table>
    </div>
</div>
</body>
</html>
