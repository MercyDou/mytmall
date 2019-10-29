<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/23
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<div class="listDataTableDiv">
    <table class="table table-striped table-bordered table-hover  table-condensed">
        <thead>
        <tr class="success">
            <th>ID</th>
            <th>用户名称</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var = "list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pageDiv">
    <%@include file="../include/admin/adminPage.jsp" %>
</div>

</body>
</html>
<%@include file="../include/admin/adminFooter.jsp"%>
