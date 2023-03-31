
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
    <title>角色管理</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
    <script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/layer/layer.js"></script>

    <style type="text/css">


    </style>

    <script type="text/javascript">

        function del(){
            var result = window.confirm("确认要删除吗?");
            if(true == result){
                alert("删除成功");
            }
        }

    </script>
</head>

<body>
<h1 class="title">首页  &gt;&gt;角色管理 </h1>

<div style="margin:0px auto; margin-left: 70px;">
</div>

<div class="add" style="margin-top:20px;">
    <a href="/role/addRolePage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加角色</a>
</div>



<table class="holidaydeptInfo">
    <tr class="titleRow">
        <td>角色ID</td>
        <td>角色名称</td>
        <td>操作列表</td>
    </tr>
    <c:forEach items="${roles}" var="item">
        <tr>
            <td>${item.roleId}</td>
            <td>${item.roleName}</td>
            <td>
                <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${item.roleId}')">
                <a href="/role/modifyrole?roleId=${item.roleId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id){
        if(confirm("确定要删除吗？")){
            // alert("是");
            window.location.href="/holiday/deleterole?roleId="+id;
        }else{
            // alert("否");//什么也不做
        }
    }
</script>
</body>
</html>
