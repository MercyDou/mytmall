<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/14
  Time: 16:35
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
    <title>属性管理</title>
</head>
<body>
<script>
    $(function(){
        $("#addForm").submit(function () {
            if (!checkEmpty("name", "属性名称")) {
                return false;
            }
            return true;
        });
    });
</script>

<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_property_list?cid=${c.id}">${c.name}</a></li>
        <li class="active">属性管理</li>
    </ol>
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <tr class="success">
                <th>ID</th>
                <th>属性名称</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            <tbody>
            <c:forEach items="${ps}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <%--要传的是产品的id--%>
                    <td><a href="admin_property_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                    <td><a deleteLink="true" href="admin_property_delete?id=${p.id}"><span class="glyphicon glyphicon-remove"></span></a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="pageDiv">
    <%@include file="../include/admin/adminPage.jsp" %>
</div>

<div class="panel panel-warning addDiv">
    <div class="panel-heading">新增属性</div>
    <div class="panel-body">
        <form method="post" id="addForm" action="admin_property_add" enctype="multipart/form-data">
            <table class="addTable">
                <tr>
                    <td>属性名称</td>
                    <td><input type="text" id="name" name="name" class="form-control"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="cid" value="${c.id}">
                        <button type="submit" class="btn btn-success">提交</button>

                    </td>

                </tr>

            </table>

        </form>
    </div>

</div>

</body>
</html>
<%@include file="../include/admin/adminFooter.jsp"%>