<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>订单管理</title>
    <script>
        $(function () {
            $("button.orderPageCheckOrderItems").click(function () {
                var oid = $(this).attr("oid");
                $("tr.orderPageOrderItemTR[oid=" + oid + "]").toggle();
            });
        });
    </script>
</head>
<body>
<div class="workingArea">
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>状态</th>
                <th>金额</th>
                <th width="100px">商品数量</th>
                <th width="100px">卖家名称</th>
                <th>创建时间</th>
                <th>支付时间</th>
                <th>发货时间</th>
                <th>确认收货时间</th>
                <th width="120px">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var = "list">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.statusDesc}</td>
                    <td>￥<fmt:formatNumber type="number" value ="${list.total}" minFractionDigits="2"/></td>
                    <td align="center">${list.totalNumber}</td>
                    <td align="center">${list.user.name}</td>

                    <td><fmt:formatNumber value="${list.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                    <td><fmt:formatNumber value="${list.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatNumber value="${list.deliveryDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatNumber value="${list.confirmDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <button oid=${list.id} class=orderPageCheckOrderItems btn btn-primary btn-xs>查看详情</button>

                        <c:if test="${list.status=='waitDelivery'}">
                            <a href="admin_order_delivery?id=${list.id}">
                                <button class="btn btn-primary btn-xs">发货</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
                <tr class="orderPageOrderItemTR"  oid=${list.id}>
                    <td colspan="10" align="center">

                        <div  class="orderPageOrderItem">
                            <table width="800px" align="center" class="orderPageOrderItemTable">
                                <c:forEach items="${list.orderItemList}" var="oi">
                                    <tr>
                                        <td align="left">
                                            <img width="40px" height="40px" src="img/productSingle/${oi.product.firstProductImage.id}.jpg">
                                        </td>

                                        <td>
                                            <a href="foreproduct?pid=${oi.product.id}">
                                                <span>${oi.product.name}</span>
                                            </a>
                                        </td>
                                        <td align="right">

                                            <span class="text-muted">${oi.number}个</span>
                                        </td>
                                        <td align="right">

                                            <span class="text-muted">单价：￥${oi.product.promotePrice}</span>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </table>
                        </div>

                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
</div>

</body>
</html>
<%@include file="../include/admin/adminFooter.jsp"%>