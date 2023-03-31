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
    <title>员工详细信息</title>

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
<h1 class="title">首页  &gt;&gt;员工管理  &gt;&gt; 查看员工详细信息 </h1>

<table>
    <tr><td>员工序号:</td><td>${info.userInfoId}</td></tr>
    <tr><td>员工号:</td><td>${info.userInfoNo}</td></tr>
    <tr><td>姓名:</td><td>${info.userName}</td></tr>
    <tr><td>所在部门</td>
        <td><c:forEach items="${depts}" var="dept">
                <c:if test="${dept.deptId == info.userDeptId}">${dept.deptName}</c:if>
            </c:forEach>
        </td>
    </tr>
    <tr><td>性别</td><td>${info.userInfoSex}</td></tr>
    <tr><td>学历</td><td>${info.userInfoEducation}</td></tr>
    <tr><td>邮箱</td><td>${info.userInfoEmail}</td></tr>
    <tr><td>电话</td><td>${info.userInfoPhone}</td></tr>
    <tr><td>入职时间</td><td> <fmt:formatDate value="${info.userInfoEntryTime}" pattern="yyyy-MM-dd" /></td></tr>
    <tr><td>创建时间</td><td> <fmt:formatDate value="${info.userInfoCreateTime}" pattern="yyyy-MM-dd" /></td></tr>
</table>
<br>

<a href="/user/userAll.jsp" target="contentPage"><input type="button" value="返回"></a>
</body>
</html>

