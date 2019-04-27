<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.Member" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/7
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Member> users = (List<Member>) request.getAttribute("users");%>
<html>
<head>
    <title>Member Admin</title>
    <style type="text/css">
        .base {
            padding-top: 100px;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }

        .user {
            border: gray solid 1px;
            border-radius: 5px;
            width: 80%;
            margin-top: 20px;
            padding: 10px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .user:hover {
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
    <div class="title"><h1>All users:</h1></div>
    <%for (Member user : users) {%>
    <div class="user" onclick="window.location.href = '/user/detail?id=<%=user.getId()%>'">
        <h3><%=user.getAccount()%>
        </h3>
        <div>Name:<%=user.getName()%>
        </div>
    </div>
    <%}%>
</div>
</body>
</html>
