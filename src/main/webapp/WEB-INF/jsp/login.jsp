<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/7
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        .base {
            padding-top: 150px;
            width: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        .card {
            width: 25%;
        }

        .link {
            color: gray;
        }

        .link:hover {
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="base">
    <div class="card">
        <div class="card-body">
            <h3 class="card-title" id="title">
                Login
            </h3>
        </div>
        <div class="card-body">
            <div class="form-group">
                <label for="account">
                    Account
                </label>
                <input type="text" class="form-control" id="account"/>
            </div>
            <div class="form-group">
                <label for="password">
                    Password
                </label>
                <input type="password" class="form-control" id="password"/>
            </div>
            <button class="btn btn-primary" id="submit" onclick="jump()">
                Login
            </button>
        </div>
        <div class="card-footer">
            <div class="link" onclick="changeMode()" id="mode">Register>></div>
        </div>
    </div>
</div>
<script>
    function changeMode() {
        var isRegister = (document.getElementById("title").innerText === "Register")
        if (!isRegister) {
            document.getElementById("title").innerText = "Register"
            document.getElementById("submit").innerText = "Register"
            document.getElementById("mode").innerText = "Login>>"
        } else {
            document.getElementById("title").innerText = "Login"
            document.getElementById("submit").innerText = "Login"
            document.getElementById("mode").innerText = "Register>>"
        }
    }

    function jump() {
        var isRegister = (document.getElementById("title").innerText === "Register")
        var account = document.getElementById("account").value;
        var password = document.getElementById("password").value;
        if (isRegister) {
            window.location.href = "/register?account=" + account + "&password=" + password;
        } else {
            window.location.href = "/login?account=" + account + "&password=" + password;
        }
    }
</script>
</body>
</html>
