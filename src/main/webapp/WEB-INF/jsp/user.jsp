<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/6
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Member member = (Member) session.getAttribute("user");
    boolean change = false;
    if (request.getAttribute("change") != null) {
        change = (boolean) request.getAttribute("change");
    }
    String identity = (String) session.getAttribute("identity");%>
<html>
<head>
    <title>Self Center</title>
    <style type="text/css">
        .base {
            padding-top: 100px;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        i.iconfont {
            font-size: 150px;
        }

        .content {
            width: 50%;
            display: flex;
            justify-content: center;
        }

        .card {
            width: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="base">
    <div class="content">
        <%if (change) {%>
        <div class="card">
            <div class="card-body">
                <form class="form-group" action="/user/modify" method="post" onsubmit="return validate_form()">
                    <label for="password">
                        Password
                    </label>
                    <input type="text" class="form-control" id="password" name="password"
                           value="<%=member.getPassword()%>"/>
                    <label for="name">
                        Name
                    </label>
                    <input type="text" class="form-control" id="name" name="name"
                           value="<%=member.getName()%>"/>
                    <label for="sex">
                        Sex
                    </label>
                    <select name="sex" id="sex" class="form-control">
                        <option value="<%=member.getSex()%>"><%=member.getSex() == 0 ? "male" : "female"%>
                        </option>
                        <option value="<%=member.getSex()==0?1:0%>"><%=member.getSex() == 1 ? "male" : "female"%>
                        </option>
                    </select>
                    <label for="address">
                        Address
                    </label>
                    <input type="text" class="form-control" id="address" name="address"
                           value="<%=member.getAddress()%>"/>
                    <label for="email">
                        Email
                    </label>
                    <input type="email" class="form-control" id="email" name="email"
                           value="<%=member.getEmail()%>"/>
                    <label for="tel">
                        Tel
                    </label>
                    <input type="number" class="form-control" id="tel" name="tel"
                           value="<%=member.getTel() == null ? "" : member.getTel() %>"/>
                    <label for="city">
                        City
                    </label>
                    <input type="text" class="form-control" id="city" name="city"
                           value="<%=member.getCity()%>"/>
                    <label for="postcode">
                        Postcode
                    </label>
                    <input type="number" min="000000" max="999999" class="form-control" id="postcode"
                           name="postcode"
                           value="<%=member.getPostcode()%>"/>
                    <br/>
                    <button class="btn btn-primary" type="submit">
                        Modify
                    </button>
                </form>
            </div>
        </div>
        <%} else {%>
        <div>
            <i class="iconfont icon-touxiang"></i>
            <div class="detail"><h5>Name:<%=member.getName()%>
            </h5></div>
            <div class="detail"><h5>Sex:  <%=member.getSex() == 0 ? "male" : "female"%>
            </h5></div>
            <div class="detail"><h5>Address: <%=member.getAddress()%>
            </h5></div>
            <div class="detail"><h5>Email:  <%=member.getEmail()%>
            </h5></div>
            <div class="detail"><h5>Tel:  <%=member.getTel() == null ? "" : member.getTel() %>
            </h5></div>
            <div class="detail"><h5>City:  <%=member.getCity()%>
            </h5></div>
            <div class="detail"><h5>Postcode:  <%=member.getPostcode()%>
            </h5></div>
            <button class="btn btn-primary" onclick="window.location.href = '/user/change'">
                Change
            </button>
            <%if ("staff".equals(identity)) {%>
            <button class="btn btn-danger" onclick="del()">
                Delete
            </button>
            <%} else {%>
            <button class="btn btn-danger" onclick="window.location.href = '/logout'">
                Logout
            </button>
            <%}%>
        </div>
        <%}%>
    </div>
</div>
</div>
<script>
    function del() {
        window.location.href = "/user/delete?id=" + <%=member.getId()%>;
    }

    function validate_form() {
        return CheckTel();
    }

    function CheckTel() {
        var tel = document.getElementById('tel').value;
        if (!(/^1[34578]\d{9}$/.test(tel))) {
            alert("phone number is wrong");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
