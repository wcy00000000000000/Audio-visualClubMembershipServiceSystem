<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/7
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String type = (String) request.getAttribute("type");
    String value = (String) request.getAttribute("value");
    String identity = (String) session.getAttribute("identity");%>
<html>
<head>
    <title>Products</title>
    <style>
        .index {
            margin-top: -100px;
        }

        .add {
            right: 30px;
            position: absolute;
        }
    </style>
</head>
<body>
<div class="base">
    <%if ("staff".equals(identity)) {%>
    <div class="add">
        <button class="btn btn-primary" onclick="window.location.href = 'product?id=-1'">
            Add
        </button>
    </div>
    <%}%>
    <div class="body">
        <h1>Filter: &nbsp;&nbsp;<%=type%>: <%=value%>
        </h1>
    </div>
</div>
<div class="index">
    <jsp:include page="index.jsp"/>
</div>
</body>
</html>
