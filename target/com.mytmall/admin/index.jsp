<%@ page import="java.sql.SQLOutput" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%
    System.out.println("***********************************************");
    System.out.println("---       欢迎来到天猫商城后台管理系统         ---");
    System.out.println("***********************************************");
    response.sendRedirect("../admin_category_list");
%>
