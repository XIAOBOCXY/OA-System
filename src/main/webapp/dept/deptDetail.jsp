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
    <title>部门详细信息</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
    <script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/layer/layer.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>

<body>
<h1 class="title">首页  &gt;&gt;部门管理  &gt;&gt; 查看部门详细信息 </h1>

<table>
    <tr><td>部门序号:</td><td>${dept.deptId}</td></tr>
    <tr><td>部门编号:</td><td>${dept.deptNo}</td></tr>
    <tr><td>部门名称:</td><td>${dept.deptName}</td></tr>
    <tr><td>部门父编号:</td><td>${dept.deptPid}</td></tr>
    <tr><td>部门负责人:</td><td>${dept.deptUser}</td></tr>
    <tr><td>部门地址:</td><td>${dept.deptAddress}</td></tr>
</table>
<br>

<a href="/dept/deptAll.jsp" target="contentPage"><input type="button" value="返回"></a>
</body>
</html>

