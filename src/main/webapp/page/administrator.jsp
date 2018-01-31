<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="page/administrator.CSS" media="screen" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />

</head>
<body>

<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                <li><a href="main">Homepage</a></li>
                <li><a href="Controller?command=listFlight">Flights</a></li>
                <li class="current_page_item"><a href="#">Administrator</a></li>
                <li><a href="Controller?command=listCrew">Dispatcher</a></li>
                <li><a href="login">Login</a></li>
                <li><a href="registration">Registration</a></li>
                </form>
            </ul>
        </div>
    </div>
    <div align="center">
        <a href="Controller?command=prepareFlight" class="button7">New Flight</a></br>
        <a href="Controller?command=listFlightForChange" class="button7">Change Flight</a></br>
        <a href="Controller?command=listFlightForDelete" class="button7">Delete Flight</a></br>
        <a href="Controller?command=prepareEmployee" class="button7">New Employee</a></br>
        <a href="Controller?command=listEmployeeForChange" class="button7">Change Employee</a></br>
        <a href="Controller?command=listEmployeeForDelete" class="button7">Delete Employee</a></br>
        <a href="Controller?command=listCrewAccept" class="button7">Check Crew</a></br>
    </div>
</div>
</body>
</html>
