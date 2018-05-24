<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
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
                    <c:choose>
                        <c:when test="${userRoleName eq 'admin'}">
                            <%@ include file="/page/JSPF/administrator(Admin).jspf"%>
                        </c:when>
                        <c:otherwise>
                            <%@ include file="/page/JSPF/administrator(Empty).jspf"%>
                        </c:otherwise>
                    </c:choose>
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
