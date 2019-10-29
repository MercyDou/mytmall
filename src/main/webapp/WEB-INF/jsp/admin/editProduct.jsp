<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/19
  Time: 14:44
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
    <title>编辑产品</title>

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
</head>
<body>
<ol class="breadcrumb">
    <li><a href="admin_category_list">所有分类</a></li>
    <%--    <li><a href="admin_property_list?cid=${p.category.id}">${p.category.name}</a></li>--%>
    <li><a href="admin_product_list?cid=${p.cid}">${p.category.name}</a></li>
    <li class="active">${p.name}</li>
    <li class="active">编辑产品</li>
</ol>
<div class="panel panel-warning editDiv ">
    <div class="panel-heading">编辑产品</div>
    <div class="panel-body">
        <form method="post" id="editForm" action="admin_product_update" enctype="multipart/form-data">
            <table class="editTable">
                <tr>
                    <td>产品名称</td>
                    <td><input type="text" id="name" name="name" class="form-control" value="${p.name}"></td>
                </tr>
                <tr>
                    <td>产品小标题</td>
                    <td><input type="text" id="subTitle" name="subTitle" class="form-control" value="${p.subTitle}"></td>
                </tr>
                <tr>
                    <td>原价格</td>
                    <td><input type="text" id="originalPrice" name="originalPrice" class="form-control" value="${p.originalPrice}"></td>
                </tr>
                <tr>
                    <td>优惠价格</td>
                    <td><input type="text" id="promotePrice" name="promotePrice" class="form-control" value="${p.promotePrice}"></td>
                </tr>
                <tr>
                    <td>库存</td>
                    <td><input type="text" id="stock" name="stock" class="form-control" value="${p.stock}"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="cid" value="${p.cid}">
                        <input type="hidden" name="id" value="${p.id}">
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
