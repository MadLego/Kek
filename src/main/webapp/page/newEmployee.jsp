<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 22.01.2018
  Time: 20:11
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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Permission</th>
                <th>Role</th>
            </tr><!-- Table Header -->
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="newEmployee"/>
            <tr>
                <td><input type="text" placeholder="Name"
                           pattern="([A-ZА-Я]{1}[a-zа-я]+)"
                           name="name" required/>
                    <span class="validity"/></td>
                <td><input type="text" placeholder="Surname"
                           pattern="([A-ZА-Я]{1}[a-zа-я]+)"
                           name="surName" required/>
                    <span class="validity"/></td>
                <td><input type="number"
                           name="age"
                           min="18" step="1" max="100" required/>
                    <span class="validity"/></td>
                <td><select name="admission">
                    <option>True</option>
                    <option>False</option>
                </select></td>
                <td><select name="role">
                    <option value="conductor">Stewardess</option>
                    <option value="navigator">Navigator</option>
                    <option value="pilot">Pilot</option>
                    <option value="radio_operator">Radio Operator</option>
                </select></td>
                <td><form action="main.html">
                    <input type="submit" name="Change"/>
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
