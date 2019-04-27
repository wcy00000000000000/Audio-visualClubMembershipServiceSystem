<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.Order" %>
<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.OrderProduct" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.OrderInfo" %>
<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/7
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% OrderInfo order = (OrderInfo) request.getAttribute("order");
    List<OrderProduct> products = (List<OrderProduct>) request.getAttribute("products");%>
<html>
<head>
    <title>Order Detail</title>
    <style type="text/css">
        .base {
            padding-top: 100px;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .content {
            width: 50%;
            display: flex;
            justify-content: center;
        }

        .card {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }

        .product {
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="base">
    <div class="content">
        <div class="card">
            <div class="card-body">
                <%if (order.getStatus().equals("submitted")) {%>
                <div class="detail"><h5>Ordered date:<%=order.getOrderDate()%>
                </h5></div>
                <%} else if (order.getStatus().equals("delivered")) {%>
                <div class="detail"><h5>Delivery date:<%=order.getDiliveryDate()%>
                </h5></div>
                <%}%>
                <%
                    for (OrderProduct orderProduct : products) {
                        if (order.getStatus().equals("new")) {
                %>
                <div class="card">
                    <div class="card-body">
                        <div><h4>Product Id: <%=orderProduct.getProductId()%>
                        </h4></div>
                        <div>Price: <%=orderProduct.getPrice()%>
                        </div>
                        <div class="form-group">
                            <label for="number<%=orderProduct.getProductId()%>">
                                Number
                            </label>
                            <input type="number" class="form-control" id="number<%=orderProduct.getProductId()%>"
                                   value="<%=orderProduct.getNumber()%>"/>
                        </div>
                        <button class="btn btn-primary" onclick="modify(<%=orderProduct.getProductId()%>)">
                            Change
                        </button>
                        <button class="btn btn-danger"
                                onclick="window.location.href = '/order/product/delete?id=<%=order.getId()%>&pid=<%=orderProduct.getProductId()%>'">
                            Delete
                        </button>
                    </div>
                </div>
                <%} else {%>
                <div class="card">
                    <div class="card-body product">
                        <div><h4>Product Id: <%=orderProduct.getProductId()%>
                        </h4></div>
                        <div>Number: <%=orderProduct.getNumber()%>
                        </div>
                        <div>Price: <%=orderProduct.getPrice()%>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                    if (order.getStatus().equals("new")) {
                %>
                <div class="form-group">
                    <label for="place">
                        Place
                    </label>
                    <input type="text" class="form-control" id="place"/>
                </div>
                <button class="btn btn-primary" onclick="order()">
                    Order
                </button>
                <button class="btn btn-danger" onclick="window.location.href = '/order/delete?id=<%=order.getId()%>'">
                    Delete
                </button>
                <%} else {%>
                <div class="detail"><h5>Place:<%=order.getPlace()%>
                </h5></div>
                <%}%>
                <%if (session.getAttribute("identity").equals("staff")) {%>
                <button class="btn btn-primary" onclick="window.location.href = '/order/deliver?id=<%=order.getId()%>'">
                    Deliver
                </button>
                <%}%>
            </div>
        </div>
    </div>
</div>
<script>
    function modify(pid) {
        var num = document.getElementById("number" + pid).value;
        window.location.href = '/order/product/modify?id=<%=order.getId()%>&pid=' + pid + '&num=' + num;
    }

    function order() {
        var place = document.getElementById("place").value;
        if (place === '') {
            alert("please fill in your address");
            return;
        }
        window.location.href = '/order/submit?id=<%=order.getId()%>&place=' + place;
    }
</script>
</body>
</html>
