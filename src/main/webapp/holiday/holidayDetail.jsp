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
    <title>请假详细信息</title>

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
<h1 class="title">首页  &gt;&gt;请假管理  &gt;&gt; 查看请假详细信息 </h1>

<table>
    <tr><td>请假序号:</td><td>${holiday.holidayId}</td></tr>
    <tr><td>请假条编号:</td><td>${holiday.holidayNo}</td></tr>
    <tr><td>申请人id:</td><td>${holiday.holidayUserId}</td></tr>
    <tr><td>请假的类型:</td><td>${holiday.holidayTypeId}</td></tr>
    <tr><td>请假人理由:</td><td>${holiday.holidayBz}</td></tr>
    <tr><td>开始时间:</td><td> <fmt:formatDate value="${holiday.holidayStartTime}" pattern="yyyy-MM-dd" /></td></tr>
    <tr><td>结束时间:</td><td> <fmt:formatDate value="${holiday.holidayEndTime}" pattern="yyyy-MM-dd" /></td></tr>
    <tr><td>请假条状态:</td><td>${holiday.holidayHolidayStatus}</td></tr>
    <tr><td>审批人id:</td><td>${holiday.holidayShenpiUserId}</td></tr>
    <tr><td>创建时间:</td><td> <fmt:formatDate value="${holiday.holidayCreateTime}" pattern="yyyy-MM-dd" /></td></tr>
    <tr><td>修改时间:</td><td> <fmt:formatDate value="${holiday.holidayUpdateTime}" pattern="yyyy-MM-dd" /></td></tr>
</table>
<br>

<a href="/holiday/holidayAll.jsp" target="contentPage"><input type="button" value="返回"></a>
</body>
</html>

