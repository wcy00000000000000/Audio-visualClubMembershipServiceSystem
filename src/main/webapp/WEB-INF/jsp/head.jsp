<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/6
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_1127825_8lgm96zr255.css">
    <style type="text/css">
        i.h {
            font-size: 30px;
            float: right;
            margin-right: 25px;
        }

        i.a {
            font-size: 25px;
            margin-left: 20px;
        }

        .header {
            box-shadow: 0 1px 20px;
            padding: 20px 0px 20px;
            z-index: 1000;
            position: fixed;
            top: 0;
            right: 0;
            left: 0;
            background: white;
        }

        @-webkit-keyframes shake {
            0% {
                opacity: 0.8;
            }
            50% {
                opacity: 0.4;
            }
            100% {
                opacity: 0.8;
            }
        }

        @keyframes shake {
            0% {
                opacity: 0.8;
            }
            50% {
                opacity: 0.4;
            }
            100% {
                opacity: 0.8;
            }
        }

        i.h:hover {
            -webkit-animation: shake 1s infinite;
            animation: shake 1s infinite;
            cursor: pointer;
        }

        a {
            text-decoration: none;
            color: black;
        }

        a:hover {
            text-decoration: none;
            color: black;
        }

        a:visited {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<div class="header">
    <a href="/"><i class="a"> Audio-visual Club Membership Service System</i></a>
    <a href="/user"><i class="iconfont icon-gerenzhongxin h"></i></a>
    <a href="/orders"><i class="iconfont icon-form h"></i></a>
    <i class="iconfont icon-sousuo1 h" onclick="search()"></i>
    <i class="iconfont h"><input type="text" id="q"></i>
</div>
<script>
    function search() {
        var q = document.getElementById("q").value;
        window.location.href = "/products?type=keyword&value=" + q;
    }
</script>
</body>
</html>
