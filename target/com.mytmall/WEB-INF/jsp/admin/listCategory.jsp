<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/10
  Time: 17:32
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
    <title>天猫商城1.0</title>
</head>
<body>
<script>
    $(function(){
        $("#addForm").submit(function () {
            if (!checkEmpty("name", "分类名称")) {
                return false;
            }
            if (!checkEmpty("categoryPic", "分类图片")) {
                return false;
            }
            return true;
        });
    });
</script>
<div class="workingArea">
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            <tbody>
            <c:forEach items="${cs}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>
                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span> </a></td>
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span> </a></td>
                    <td><a href="admin_category_get?id=${c.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="glyphicon glyphicon-remove"></span></a> </td>
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
    <div class="panel-heading">新增分类</div>
    <div class="panel-body">
        <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
            <table class="addTable">
                <tr>
                    <td>分类名称</td>
                    <td><input type="text" id="name" name="name" class="form-control"></td>
                </tr>
                <tr>
                    <td>分类图片</td>
                    <td><input type="file" id="categoryPic" accept="image/*" name="image"/></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
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