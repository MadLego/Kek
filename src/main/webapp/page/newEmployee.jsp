<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 22.01.2018
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
    <div>
        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th><fmt:message key="employee.label.firstName" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.lstName" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.age" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.permission" bundle="${lang}"/></th>
                <th><fmt:message key="employee.label.role" bundle="${lang}"/></th>
            </tr><!-- Table Header -->
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="newEmployee"/>
            <tr>
                <td><input type="text" placeholder="<fmt:message key="employee.label.firstName" bundle="${lang}"/>"
                           pattern="([A-ZА-Я]{1}[a-zа-я]+)"
                           name="name" required/>
                    <span class="validity"/></td>
                <td><input type="text" placeholder="<fmt:message key="employee.label.lstName" bundle="${lang}"/>"
                           pattern="([A-ZА-Я]{1}[a-zа-я]+)"
                           name="surName" required/>
                    <span class="validity"/></td>
                <td><input type="number"
                           name="age"
                           min="18" step="1" max="100" required/>
                    <span class="validity"/></td>
                <td><select name="admission">
                    <option><fmt:message key="label.vew.true" bundle="${lang}"/></option>
                    <option><fmt:message key="label.vew.false" bundle="${lang}"/></option>
                </select></td>
                <td><select name="role">
                    <option value="conductor"><fmt:message key="crewAdmission.label.stewardess" bundle="${lang}"/></option>
                    <option value="navigator"><fmt:message key="crewAdmission.label.navigator" bundle="${lang}"/></option>
                    <option value="pilot"><fmt:message key="crewAdmission.label.pilot" bundle="${lang}"/></option>
                    <option value="radio_operator"><fmt:message key="crewAdmission.label.radioOperator" bundle="${lang}"/></option>
                </select></td>
                <td><form action="main">
                    <input type="submit" name="<fmt:message key="flight.label.changeFlight" bundle="${lang}"/>"/>
                </form></td>
            </tr><!-- Table Row -->
            </form>

        </table>
        <c:forEach var="item" items="${errors}">
            <p style="color: red" align="center"><c:out value="${item}"/></p>
        </c:forEach>
    </div>
</div>
<!-- end #footer -->
</body>
</html>
