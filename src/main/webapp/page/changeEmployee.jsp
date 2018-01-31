<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 18.01.2018
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator</title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css"/>

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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Permission</th>
                <th>Role</th>
            </tr>

        <form action="Controller?command=changeEmployee" method="post">
            <tr>
            <c:forEach var="item" items="${changeThisEmployee}">
                <td style="display:none;"><input type="hidden" name="id" value="${item.id}"></td>
                <td><input type="text" placeholder="Name"
                pattern="([A-Z]{1}[a-z]+)"
                name="name" value="${item.firstName}" required/>
                    <span class="validity"/></td>
                <td><input type="text" placeholder="Surname"
                pattern="([A-Z]{1}[a-z]+)"
                name="surName" value="${item.lastName}"required/>
                    <span class="validity"/></td>
                <td><input type="number"
                           min="18" step="1" name="age" value="${item.age}"required/>
                    <span class="validity"></span></td>
                </td>
                <td><select name="admission">
                    <option>True</option>
                    <option>False</option>
                </select></td>
                <td><select name="role">
                <c:forEach var="i" items="${roleList}">
                    <option><c:out value="${i}"/></option>
                </c:forEach>
                </select></td>
                <td>
                        <input type="submit" name="change"/>
                </td>
            </c:forEach>
            </tr>
        </form>
        </table>
    </div>
</div>
</body>
</html>
