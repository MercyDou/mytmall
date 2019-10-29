<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/10
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<html>
<head>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="css/back/style.css" rel="stylesheet">

    <script>
        function checkEmpty(id,name) {
            var value = $("#" + id).val();//val()方法返回或设置被选元素的值。如果该方法未设置参数，则返回被选元素的当前值。
            if (value.length == 0) {
                alert("内容不能为空！");
                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }

        function checkNumber(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert("内容不能为空！");
                $("#" + id)[0].focus();
                return false;
            }
            if (isNaN(value)) {
                alert(name + "必须为数字！");
                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }

        function checkInt(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert("内容不能为空！");
                $("#" + id)[0].focus();
                return false;
            }
            //parseInt(value,radix)解析value字符串并返回一个整数，radix不设置会以十进制来解析；只有字符串中的第一个数字会被返回
            if (parseInt(value) != value) {
                alert("必须是整数！");
                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }

        $(function(){
            $("a").click(function () {
                var deleteLink = $(this).attr("deleteLink");
                console.log(deleteLink);
                if ("true" == deleteLink) {
                    var confirmDelete = confirm("确认要删除吗？");
                    if (confirmDelete) {
                        return true;
                    }
                    return false;
                }

            });
        })
    </script>
</head>
<body>


</body>
</html>
