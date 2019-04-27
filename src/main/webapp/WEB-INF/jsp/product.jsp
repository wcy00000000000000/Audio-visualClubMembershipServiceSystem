<%--
  Created by IntelliJ IDEA.
  User: WCY
  Date: 2019/4/7
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.wcy.audio_visual_club_membership_service_system.pojo.Product" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% Product product = (Product) request.getAttribute("product");
    int pid = -1;
    if (product != null) {
        pid = product.getId();
    }
%>
<html>
<head>
    <title>Product Detail</title>
    <style type="text/css">
        .base {
            padding-top: 100px;
            width: 100%;
        }

        i.icon-yinxiang {
            font-size: 200px;
            border: gainsboro 1px solid;
        }

        .detail {
            margin-top: 20px;
        }

        .flex-row {
            display: flex;
            flex-direction: row;
        }

        .add {
            margin-left: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container base">
    <%
        if (session.getAttribute("identity") != null && session.getAttribute("identity").equals("staff")) {
            if (product == null) {
    %>
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">

            <div class="card">
                <div class="card-body">
                    <form class="form-group" action="/product/add" method="post">
                        <label for="name1">
                            Product name
                        </label>
                        <input type="text" class="form-control" id="name1" name="name"/>
                        <label for="type1">
                            Product type
                        </label>
                        <input type="text" class="form-control" id="type1" name="type"/>
                        <label for="price1">
                            Price
                        </label>
                        <input type="number" min="0.00" step="0.01" class="form-control" id="price1" name="price"/>
                        <label for="p-price1">
                            Promotion Price
                        </label>
                        <input type="number" min="0.00" step="0.01" class="form-control" id="p-price1"
                               name="prormotionPrice"/>
                        <label for="place1">
                            Product production place
                        </label>
                        <input type="text" class="form-control" id="place1" name="productionPlace"/>
                        <label for="director1">
                            Director
                        </label>
                        <input type="text" class="form-control" id="director1" name="director"/>
                        <label for="actor1">
                            Actor
                        </label>
                        <input type="text" class="form-control" id="actor1" name="actor"/>
                        <label for="date1">
                            Release date
                        </label>
                        <input type="date" class="form-control" id="date1" name="releaseDate" value="1990-01-01"/>
                        <label for="specification1">
                            Specification
                        </label>
                        <input type="text" class="form-control" id="specification1" name="specification"/>
                        <br/>
                        <button class="btn btn-primary" id="submit" type="submit">
                            Add
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%} else {%>
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <div class="card">
                <div class="card-body">
                    <form class="form-group" action="/product/modify" method="post">
                        <label for="name2">
                            Product name
                        </label>
                        <input type="text" class="form-control" id="name2" name="name" value="<%=product.getName()%>"/>
                        <label for="type2">
                            Product type
                        </label>
                        <input type="text" class="form-control" id="type2" name="type" value="<%=product.getType()%>"/>
                        <label for="price2">
                            Price
                        </label>
                        <input type="number" min="0.00" step="0.01" class="form-control" id="price2" name="price"
                               value="<%=product.getPrice()%>"/>
                        <label for="p-price2">
                            Promotion Price
                        </label>
                        <input type="number" min="0.00" step="0.01" class="form-control" id="p-price2"
                               name="prormotionPrice"
                               value="<%=product.getPrormotionPrice()%>"/>
                        <label for="place2">
                            Product production place
                        </label>
                        <input type="text" class="form-control" id="place2" name="productionPlace"
                               value="<%=product.getProductionPlace()%>"/>
                        <label for="director2">
                            Director
                        </label>
                        <input type="text" class="form-control" id="director2" name="director"
                               value="<%=product.getDirector()%>"/>
                        <label for="actor2">
                            Actor
                        </label>
                        <input type="text" class="form-control" id="actor2" name="actor"
                               value="<%=product.getActor()%>"/>
                        <label for="date2">
                            Release date
                        </label>
                        <input type="date" class="form-control" id="date2" name="releaseDate"
                               value="<%=new SimpleDateFormat("yyyy-MM-dd").format(product.getReleaseDate())%>"/>
                        <label for="specification2">
                            Specification
                        </label>
                        <input type="text" class="form-control" id="specification2" name="specification"
                               value="<%=product.getSpecification()%>"/>
                        <br/>
                        <button class="btn btn-primary" type="submit">
                            Modify
                        </button>
                    </form>
                    <button class="btn btn-danger" onclick="del()">
                        Delete
                    </button>
                </div>
            </div>
        </div>
    </div>
    <%
        }
    } else {
    %>
    <div class="row">
        <div class="col-4"></div>
        <div class="col-8">
            <h1>Product name:  <%=product.getName()%>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <i class="iconfont icon-yinxiang"></i>
            <div class="flex-row">
                <input type="number" class="form-control" style="width: 100px" value="1" id="num" min="1">
                <button type="button" class="btn btn-primary add" onclick="order()">Add</button>
            </div>
        </div>
        <div class="col-8">
            <div class="detail"><h5>Product type:  <%=product.getType()%>
            </h5></div>
            <div class="detail"><h5>Price: <s><%=product.getPrice()%>
            </s>
            </h5></div>
            <div class="detail"><h5>Promotion price:  <%=product.getPrormotionPrice()%>
            </h5></div>
            <div class="detail"><h5>Product production place:  <%=product.getProductionPlace()%>
            </h5></div>
            <div class="detail"><h5>Director:  <%=product.getDirector()%>
            </h5></div>
            <div class="detail"><h5>Actor:  <%=product.getActor()%>
            </h5></div>
            <div class="detail"><h5>Release date:  <%=product.getReleaseDate()%>
            </h5></div>
            <div class="detail"><h5>Specification:  <%=product.getSpecification()%>
            </h5></div>
        </div>
    </div>
    <%}%>
</div>
<script>
    function order() {
        var num = document.getElementById("num").value;
        window.location.href = "/order/add?num=" + num + "&pid=" +<%=pid%>;
    }

    function del() {
        window.location.href = "/product/delete?pid=" + <%=pid%>;
    }
</script>
</body>
</html>
