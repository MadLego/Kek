<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/language.tld" prefix="mytag"%>
<%@ taglib prefix="my" uri="mytaglib.tld" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Rubezhaka-Air</title>
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />
    <link href="page/mainCSS.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="page/searchCSS.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="FlightBundle" var="lang" />
<body>
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
<my:my/>

<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command"  method="post">
                    <input type="hidden" name="command">
                <li class="current_page_item"><a href="#"><fmt:message key="page.label.homePage" bundle="${lang}"/></a></li>
                <li><a href="Controller?command=listFlight&language=${lang}"><fmt:message key="page.label.flights" bundle="${lang}"/></a></li>
                <li><a href="administrator"><fmt:message key="page.label.administrator" bundle="${lang}"/></a></li>
                <li><a href="Controller?command=listCrew"><fmt:message key="page.label.dispatcher" bundle="${lang}"/></a></li>
                <li><a href="login"><fmt:message key="page.label.login" bundle="${lang}"/></a></li>
                <li><a href="registration"><fmt:message key="page.label.registration" bundle="${lang}"/></a></li>
                </form>
            </ul>
        </div>
    </div>
    <div id="header">
        <div id="logo" class="container">
            <h1><a href="#">Rubezhaka-Air </a></h1>
            <p>EEEE BOY</p>
            <form action="Controller" method="post" class="search">
                <input type="hidden" name="command" value="searchFlight"/>
                <input type="search" name="searchItem" placeholder="Search" class="input" />
                <input type="submit" name="" value="" class="submit" />
            </form>
        </div>
    </div>
    <div id="page" class="container">
        <div id="content">
            <h2><a href="#">Welcome to Rubikon-Air </a></h2>
            <div class="entry">
                <p><img src="page/images/img14.jpg" width="690" height="200" alt="" /></p>
                <p>This is <strong>Rubikon-Air </strong>,  is Ukrainian largest airline and the largest provider of scheduled passenger services in the Ukraine market, the Ukrain-Europ transborder market and in the international market to and from Ukraine.  In 2016, Rubikon Air together with its Air Canada Express regional partners carried close to 45 million passengers, offering direct passenger service to more than 200 destinations on six continents.  Rubikon Air is a founding member of Star Alliance, providing the world's most comprehensive air transportation network.</br>
                    Rubikon Air is among the 20 largest airlines in the world and employs 30,000 people.  Its corporate headquarters are located in Rubezhaka. </p>
            </div>
        </div>
        <!-- end #content -->
    </div>

</div>
<div id="footer-content" class="container">
    <div id="footer-bg">
    </div>
</div>
<!-- end #footer -->
</body>
</html>
