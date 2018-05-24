<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 05.02.2018
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Available</title>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />
    <link href="page/mainCSS.css" rel="stylesheet" type="text/css" media="screen" />
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css" />
</head>

<body>
<my:my/>

<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command"  method="post">
                    <input type="hidden" name="command">
                    <c:choose>
                        <c:when test="${userRoleName eq 'admin'}">
                            <%@ include file="/page/JSPF/main(Admin).jspf"%>
                        </c:when>
                        <c:when test="${userRoleName eq 'dispatcher'}">
                            <%@ include file="/page/JSPF/main(Dispatcher).jspf"%>
                        </c:when>
                        <c:otherwise>
                            <%@ include file="/page/JSPF/main(Empty).jspf"%>
                        </c:otherwise>
                    </c:choose>
                </form>
            </ul>
        </div>
    </div>
    <table class="simple-little-table" cellspacing='0'>
        <tr>
            <th><c:out value="Pilot"/></th>
            <th><c:out value="Naviagator"/></th>
            <th><c:out value="Radio Operator"/></th>
            <th><c:out value="Conductor"/></th>
        </tr>
        <tr>
            <td><c:out value="${pilotCounter}"/></td>
            <td><c:out value="${pilotNavigator}"/></td>
            <td><c:out value="${pilotRadioOperator}"/></td>
            <td><c:out value="${pilotConductor}"/></td>
        </tr>
    </table>
</div>

</body>
</html>
