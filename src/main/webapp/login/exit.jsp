<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/6/20
  Time: 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
    <html>
    <head>
        <meta charset="UTF-8"/>
        <title>退出系统</title>
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="this is my page">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css">
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
        <script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/js/layer/layer.js"></script>

        <style type="text/css">


        </style>


    </head>

<body>
<h1 class="title">首页  &gt;&gt;退出系统 </h1>
<script type="text/javascript" language="javascript">
    alert("真的要退出系统吗");
    parent.location.href="/";
</script>
<div style="margin:0px auto; margin-left: 70px;">
</div>



<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>

</script>
</body>
</html>


