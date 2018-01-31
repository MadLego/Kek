<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 23.01.2018
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator</title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />

</head>
<body>

<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul class="menu">
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                    <li><a href="main">Homepage</a></li>
                    <li><a href="Controller?command=listFlight">Flights</a></li>
                    <li><a href="administrator">Administrator</a></li>
                    <li><a href="Controller?command=listCrew">Dispatcher</a></li>
                    <li><a href="login">Login</a></li>
                    <li><a href="registration">Registration</a></li>
                </form>
            </ul>
        </div>
    </div>
    <div>
        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>First Name </th>
                <th>Last Name </th>
                <th>Age </th>
                <th>Role</th>
            </tr><!-- Table Header -->

        <c:forEach var="item" items="${employeesList}">
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="deleteEmployee">
            <tr>
                <td style="display: none"><input type="hidden" name="id" value="<c:out value="${item.id}"/>"><c:out value="${item.id}"/></td>
                <td><c:out value="${item.firstName}"/></td>
                <td><c:out value="${item.lastName}"/></td>
                <td><c:out value="${item.age}"/></td>
                <td><c:out value="${item.role}"/></td>
                <td><input type="submit" name="Delete"/></td>
            </tr><!-- Table Row -->
            </form>
        </c:forEach>
        </table>
    </div>
</div>
<!-- end #footer -->
</body>
</html>
