<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 18.01.2018
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/page/header.jspf"%>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.label.login" bundle="${lang}"/></title>
    <link rel="stylesheet" href="page/loginCSS.css" media="screen" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet" type="text/css" />

</head>
<body>
<my:my/>
<div id="wrapper">
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <form action="Controller" name="command" method="post">
                    <input type="hidden" name="command">
                    <li><a href="main"><fmt:message key="page.label.homePage" bundle="${lang}"/></a></li>
                    <li><a href="Controller?command=listFlight"><fmt:message key="page.label.flights" bundle="${lang}"/></a></li>
                    <li><a href="administrator"><fmt:message key="page.label.administrator" bundle="${lang}"/></a></li>
                    <li><a href="Controller?command=listCrew"><fmt:message key="page.label.dispatcher" bundle="${lang}"/></a></li>
                    <li class="current_page_item"><a href="#"><fmt:message key="page.label.login" bundle="${lang}"/></a></li>
                    <li><a href="registration"><fmt:message key="page.label.registration" bundle="${lang}"/></a></li>
                </form>
            </ul>
        </div>
    </div>

</div>
<div id="login">
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="login">
        <fieldset class="clearfix">
            <p><span class="fontawesome-user"></span><input type="text" name="username" value="Username" onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
            <p><span class="fontawesome-lock"></span><input type="password" name="password"  value="Password" onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <p><input type="submit" value="<fmt:message key="label.view.login" bundle="${lang}"/>"></p>
        </fieldset>
    </form>
    <p style="color: red"><c:out value="${loginResult}"/></p>
    <p><fmt:message key="login.label.noAccountYet" bundle="${lang}"/> &nbsp;&nbsp;<a href="registration"><fmt:message key="page.label.registration" bundle="${lang}"/></a><span class="fontawesome-arrow-right"></span></p>
</div>
</body>
</html>
