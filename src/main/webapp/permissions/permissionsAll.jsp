
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
    <title>权限管理</title>
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
<h1 class="title">首页  &gt;&gt;权限管理 </h1>

<div style="margin:0px auto; margin-left: 70px;">
    <form action="/permissions/searchPermissions" method="post">
        角色：<select name="permissionsRoleId">
        <option value="0">---请选择---</option>
        <c:forEach items="${roles}" var="item">
            <option value="${item.roleId}">${item.roleName}</option>
        </c:forEach>
    </select>
        菜单：<select name="permissionsMenuId">
        <option value="0">---请选择---</option>
        <!-- 加入所有可以查询到的二级部门， -->
        <c:forEach items="${menus}" var="item">
            <option value="${item.menuId}">${item.menuName}</option>
        </c:forEach>
    </select>
        <input type="submit" value="查询"/>
    </form>
</div>

<div class="add" style="margin-top:20px;">
    <a href="/permissions/addpermissionsPage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加权限</a>
</div>



<table class="holidaydeptInfo">
    <tr class="titleRow">
        <td>权限编号</td>
        <td>角色名称</td>
        <td>菜单ID</td>
        <td>菜单名称</td>
        <td>操作列表</td>
    </tr>
    <c:forEach items="${permissionss}" var="item">
        <tr>
            <td>${item.permissionsId}</td>
            <td>
                <c:forEach items="${roles}" var="role">
                    <c:if test="${role.roleId == item.permissionsRoleId}">${role.roleName}</c:if>
                </c:forEach>
            </td>
            <td>${item.permissionsMenuId}</td>
            <td>
                <c:forEach items="${menus}" var="menu">
                    <c:if test="${menu.menuId == item.permissionsMenuId}">${menu.menuName}</c:if>
                </c:forEach>
            </td>
            <td>
                <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${item.permissionsId}')">
                <a href="/permissions/modifypermissions?permissionsId=${item.permissionsId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id){
        if(confirm("确定要删除吗？")){
            // alert("是");
            window.location.href="/permissions/deletepermissions?permissionsId="+id;
        }else{
            // alert("否");//什么也不做
        }
    }
</script>
</body>
</html>
