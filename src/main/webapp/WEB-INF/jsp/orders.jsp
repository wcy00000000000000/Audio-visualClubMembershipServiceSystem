<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.OrderInfo" %><%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/7
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<OrderInfo> orders = new ArrayList<>();
    if (request.getAttribute("orders") != null) {
        orders = (List<OrderInfo>) request.getAttribute("orders");
    }%>
<html>
<head>
    <title>Orders</title>
    <style type="text/css">
        .base {
            padding-top: 100px;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }

        .order {
            border: gray solid 1px;
            border-radius: 5px;
            width: 80%;
            margin-top: 20px;
            padding: 10px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .order:hover {
            cursor: pointer;
        }

        .title {
            width: 100%;
            padding-left: 100px;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="base">
    <div class="title"><h1>All orders:</h1></div>
    <%for (OrderInfo order : orders) {%>
    <div class="order" onclick="window.location.href = '/order?id=<%=order.getId()%>'">
        <h3><%=order.getId()%>
        </h3>
        <div>status:<%=order.getStatus()%>
        </div>
    </div>
    <%}%>
</div>
</body>
</html>
