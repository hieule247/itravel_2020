<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/page-user.css" rel="stylesheet" type="text/css">
    <link href="resources/css/main.css" rel="stylesheet" type="text/css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/js/common.js"></script>
    <script type="text/javascript" src="resources/js/lib.js"></script>
<!--
    <script type="text/javascript" src="resources/js/loginAjax.js"></script>
-->
    <script type="text/javascript" src="resources/js/initDataAjax.js"></script>
    <title>iTravel</title>
</head>

<body id="home" class=" client-js" style="">
  <%@include file="headerNone.jsp"%>

<div id="test-body-mobile">
    <div id="contentHead">
        <h1>Login Form</h1>
    </div>
    <div id="contentBody">
        <form id="loginFormId" name="loginForm" method="post" action="loginServlet">
        <div id="loginForm">
            <fieldset>
                <label>user/user or admin/admin</label><hr>
                <label for="txtUserName">Email</label>
                <input type="text" id="txtUserName" name="txtUserName" value="user"><br>
                <label for="txtPassword">Password</label>
                <input type="password" id="txtPassword" name="txtPassword" value="user"><br>
                <a href="#forgotPassword">Forgot Password?</a><br>
                <input type="submit" id="btnLogin" name="btnLogin" value="LOGIN"><br>
                <label>Not a member?</label><a href="signupForm.jsp">Signup Now</a>
            </fieldset>
        </div>
        </form>
<!--        <form id="loginFormId" name="loginForm" method="post" action="loginServlet">
            <div id="usernameDiv" class="paddingBtm">
                <span id="user">Username: </span><input id="userInput" type="text" name="username" />
            </div>
            <div id="passwordDiv" class="paddingBtm">
                <span id="pass">Password: </span><input id="passInput" type="password" name="password" />
            </div>
            <div id="loginBtn">
                <input id="btn" type="submit" value="Login" />
            </div>
        </form>
-->
        <div id="tabsHistory" class="tabs autohash ui-tabs ui-corner-all ui-widget ui-widget-content">

            <div id="humans" aria-labelledby="ui-id-1" role="tabpanel"
                 class="ui-tabs-panel ui-corner-bottom ui-widget-content" aria-hidden="false"
                 style="display: block;">

            </div>
        </div>
    </div>
</div>




<div class="clearfix"></div>


<footer>
    <div id="footer-content">

        <hr>

    </div>
</footer>


<div id="cboxOverlay" style="display: none;"></div>
<div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;">
    <div id="cboxWrapper">
        <div>
            <div id="cboxTopLeft" style="float: left;"></div>
            <div id="cboxTopCenter" style="float: left;"></div>
            <div id="cboxTopRight" style="float: left;"></div>
        </div>
        <div style="clear: left;">
            <div id="cboxMiddleLeft" style="float: left;"></div>
            <div id="cboxContent" style="float: left;">
                <div id="cboxTitle" style="float: left;"></div>
                <div id="cboxCurrent" style="float: left;"></div><button type="button"
                                                                         id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button
                    id="cboxSlideshow"></button>
                <div id="cboxLoadingOverlay" style="float: left;"></div>
                <div id="cboxLoadingGraphic" style="float: left;"></div>
            </div>
            <div id="cboxMiddleRight" style="float: left;"></div>
        </div>
        <div style="clear: left;">
            <div id="cboxBottomLeft" style="float: left;"></div>
            <div id="cboxBottomCenter" style="float: left;"></div>
            <div id="cboxBottomRight" style="float: left;"></div>
        </div>
    </div>
    <div style="position: absolute; width: 9999px; visibility: hidden; display: none; max-width: none;"></div>
</div>

<p> This is a test</p>

</body>

</html>