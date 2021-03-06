<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 24.01.2018
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
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
    <div id="header">
        <div id="logo" class="container">
            <h1><a href="#">Open-Air</a></h1>
            <p>Flights</p>
            <form action="Controller" method="get" class="search">
                <input type="hidden" name="command" value="searchFlight"/>
                <input type="search" name="searchItem" placeholder="<fmt:message key="label.view.sort" bundle="${lang}"/>" class="input" />
                <input type="submit" name="" value="" class="submit" />
            </form>
        </div>
    </div>
    <div id="page" class="container">
        <div id="content">
            <h2><a href="#">Welcome to Open-Air</a></h2>
            <div class="entry">
                <p><img src="page/images/img14.jpg" width="690" height="200" alt="" /></p>
                <p>This is <strong>Open-Air</strong>,  is Ukrainian largest airline and the largest provider of scheduled passenger services in the Ukraine market, the Ukrain-Europ transborder market and in the international market to and from Ukraine.  In 2016, Open Air together with its Air Canada Express regional partners carried close to 45 million passengers, offering direct passenger service to more than 200 destinations on six continents.  Open Air is a founding member of Star Alliance, providing the world's most comprehensive air transportation network.</br>
                    Open Air is among the 20 largest airlines in the world and employs 30,000 people.  Its corporate headquarters are located in Open Air. </p>
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
