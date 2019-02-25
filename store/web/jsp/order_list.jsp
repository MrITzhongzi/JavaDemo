﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>

<body>
<%@include file="/jsp/header.jsp" %>

</nav>

<div class="container">
    <div class="row">

        <div style="margin:0 auto; margin-top:10px;width:950px;">
            <strong>我的订单</strong>
            <table class="table table-bordered">
                <c:forEach items="${page.list}" var="item">
                    <tbody>
                    <tr class="success">
                        <th colspan="5">订单编号:${item.oid}</th>
                    </tr>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <c:forEach items="${item.list}" var="pro">
                    <tr class="active">
                        <td width="60" width="40%">
                            <input type="hidden" name="id" value="22">
                            <img src="${pageContext.request.contextPath}/${pro.product.pimage}" width="70"
                                 height="60">
                        </td>
                        <td width="30%">
                            <a target="_blank"> ${pro.product.pname}</a>
                        </td>
                        <td width="20%">
                            ￥${pro.product.shop_price}
                        </td>
                        <td width="10%">
                            ${pro.quantity}
                        </td>
                        <td width="15%">
                            <span class="subtotal">￥${pro.total}</span>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    <%--分页--%>
    <%@include file="/jsp/pageFile.jsp" %>
</div>

<div style="margin-top:50px;">
    <img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势"/>
</div>

<%@include file="/jsp/footer.jsp" %>
</body>

</html>