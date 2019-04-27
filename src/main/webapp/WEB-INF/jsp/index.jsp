<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/6
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Product> products = (List<Product>) request.getAttribute("products");%>
<html>
<head>
    <title>Audio-visual Club Membership Service System</title>
    <style type="text/css">
        .base {
            padding-top: 100px;
            width: 100%;
            display: flex;
            flex-direction: row;
        }

        i.icon-yinxiang {
            font-size: 130px;
        }

        .side {
            width: 270px;
            display: flex;
            flex-direction: column;
            box-shadow: 1px 0 20px;
            position: fixed;
            top: 90px;
            bottom: 0;
        }

        .option {
            padding: 30px 0;
            font-size: 20px;
            text-align: center;
            border-bottom: gray dashed 1px;
        }

        .body {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            margin-left: 290px;
        }

        .product {
            width: 22%;
            height: 37%;
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
            border: 1px solid rgba(0, 0, 0, .125);
        }

        .product:hover {
            cursor: pointer;
        }

        .subside {
            display: flex;
            flex-direction: column;
            box-shadow: 21px 0 20px;
            z-index: 10;
            top: 90px;
            left: 270px;
            background-color: white;
            bottom: 0;
            width: 270px;
            position: fixed;
        }

        .sub {
            font-size: 20px;
            margin: 10px;
            padding: 10px 0;
            text-align: center;
        }

        .sub:hover {
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="base">
    <div class="side">
        <div class="option" onmouseover="show('type')" onmouseleave="hide('type')">type</div>
        <div class="option" onmouseover="show('price')" onmouseleave="hide('price')">price</div>
        <div class="option" onmouseover="show('place')" onmouseleave="hide('place')">production place</div>
        <div class="option" onmouseover="show('date')" onmouseleave="hide('date')">release date</div>
    </div>
    <div class="subside" onmouseover="show('type')" onmouseleave="hide('type')" id="type">
        <%
            String[] types = {"t0", "t1", "t2", "t3", "t4", "t5", "t6"};
            for (String type : types) {%>
        <div class="sub" onclick="filter('type','<%=type%>')"><%=type%>
        </div>
        <%}%>
    </div>
    <div class="subside" onmouseover="show('price')" onmouseleave="hide('price')" id="price">
        <%
            String[] prices = {"0-10", "10-50", "50-100", ">100"};
            for (String price : prices) {%>
        <div class="sub" onclick="filter('price','<%=price%>')"><%=price%>
        </div>
        <%}%>
    </div>
    <div class="subside" onmouseover="show('place')" onmouseleave="hide('place')" id="place">
        <%
            String[] places = {"China", "French", "UK", "US", "German"};
            for (String place : places) {%>
        <div class="sub" onclick="filter('place','<%=place%>')"><%=place%>
        </div>
        <%}%>
    </div>
    <div class="subside" onmouseover="show('date')" onmouseleave="hide('date')" id="date">
        <%
            String[] dates = {"<1990", "1990-2000", "2000-2010", ">2010"};
            for (String date : dates) {%>
        <div class="sub" onclick="filter('date','<%=date%>')"><%=date%>
        </div>
        <%}%>
    </div>
    <div class="s"></div>
    <div class="body">
        <%for (Product p : products) {%>
        <div class="product" onclick="showDetail(<%=p.getId()%>)">
            <i class="iconfont icon-yinxiang"></i>
            <%=p.getName()%>
        </div>
        <%}%>
    </div>
</div>
<script>
    document.getElementById("type").hidden = true;
    document.getElementById("price").hidden = true;
    document.getElementById("place").hidden = true;
    document.getElementById("date").hidden = true;

    function show(op) {
        document.getElementById(op).hidden = false;
    }

    function hide(op) {
        document.getElementById(op).hidden = true;
    }

    function showDetail(id) {
        window.location.href = "/product?id=" + id;
    }

    function filter(type, value) {
        window.location.href = "/products?type=" + type + "&value=" + value;
    }
</script>
</body>
</html>
