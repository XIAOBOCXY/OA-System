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
    <title>报销详细信息</title>

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
<h1 class="title">首页  &gt;&gt;报销管理  &gt;&gt; 查看报销详细信息 </h1>

<table>
    <tr><td>报销序号:</td><td>${baoxiao.baoxiaoId}</td></tr>
    <tr><td>报销编号:</td><td>${baoxiao.baoxiaoNo}</td></tr>
    <tr><td>报销申请人:</td><td>${baoxiao.baoxiaoUserId}</td></tr>
    <tr><td>报销类型:</td><td>${baoxiao.baoxiaoType}</td></tr>
    <tr><td>报销摘要:</td><td>${baoxiao.baoxiaoTest}</td></tr>
    <tr><td>报销金额:</td><td>${baoxiao.baoxiaoMoney}</td></tr>
    <tr><td>报销申请时间:</td><td> <fmt:formatDate value="${baoxiao.baoxiaoCreateTime}" pattern="yyyy-MM-dd" /></td></tr>
    <tr><td>报销申请状态:</td><td>${baoxiao.baoxiaoStatus}</td></tr>
</table>
<br>

<a href="/baoxiao/baoxiaoAll.jsp" target="contentPage"><input type="button" value="返回"></a>
</body>
</html>

