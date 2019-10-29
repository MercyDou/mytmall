<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/18
  Time: 9:21
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
    <title>产品管理</title>
</head>
<body>
<script>
    $(function(){
        $("#addForm").submit(function () {
            if (!checkEmpty("name", "产品名称")) {
                return false;
            }
            if (!checkNumber("originalPrice", "原价格")) {
                return false;
            }
            if (!checkNumber("promotePrice", "优惠价格")) {
                return false;
            }
            if (!checkInt("stock", "库存")) {
                return false;
            }
            return true;
        });
    });
</script>

<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${c.id}">${c.name}</a></li>
        <li class="active">产品管理</li>
    </ol>
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>产品名称</th>
                <th>产品小标题</th>
                <th width="53px">原价格</th>
                <th width="80px">优惠价格</th>
                <th width="80px">库存数量</th>
                <th width="80px">图片管理</th>
                <th width="80px">设置属性</th>
                <th width="42px">编辑</th>
                <th width="42px">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ps}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td width="53px">图片</td>
                    <td>${p.name}</td>
                    <td>${p.subTitle}</td>
                    <td>${p.originalPrice}</td>
                    <td>${p.promotePrice}</td>
                    <td>${p.stock}</td>
                    <td><a href="admin_pic_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                    <td><a href="admin_picproperty_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                        <%--要传的是产品属性的id--%>
                    <td><a href="admin_product_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                    <td><a deleteLink="true" href="admin_product_delete?id=${p.id}"><span class="glyphicon glyphicon-remove"></span></a> </td>
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
    <div class="panel-heading">新增产品</div>
    <div class="panel-body">
        <form method="post" id="addForm" action="admin_product_add" enctype="multipart/form-data">
            <table class="addTable">
                <tr>
                    <td>产品名称</td>
                    <td><input type="text" id="name" name="name" class="form-control"></td>
                </tr>
                <tr>
                    <td>产品小标题</td>
                    <td><input type="text" id="subTitle" name="subTitle" class="form-control"></td>
                </tr>
                <tr>
                    <td>原价格</td>
                    <td><input type="text" id="originalPrice" name="originalPrice" class="form-control"></td>
                </tr>
                <tr>
                    <td>优惠价格</td>
                    <td><input type="text" id="promotePrice" name="promotePrice" class="form-control"></td>
                </tr>
                <tr>
                    <td>库存</td>
                    <td><input type="text" id="stock" name="stock" class="form-control"></td>
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
