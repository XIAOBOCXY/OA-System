
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
    <title>修改权限信息</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
    <script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/layer/layer.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <style type="text/css">
        body,div,table,tr,td{
            margin: 0px;
            padding: 0px;
        }

        #deptEditTable{
            font-size: 15px;
            border-collapse: collapse;
            width: 350px;
            margin: 20px auto;


        }

        #deptEditTable td{
            height: 40px;
        }

    </style>
</head>

<body>
<h1 class="title">首页  &gt;&gt;权限管理  &gt;&gt; 编辑权限信息 </h1>
<form action="/permissions/editPermissions" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                权限序号:
            </td>
            <td>
                <input type = "text" name="permissionsId" id="permissionsId" value="${permissions.permissionsId}" readonly disabled />
            </td>
        </tr>
        <tr>
            <td>
                权限角色:
            </td>
            <td>
                <select name="permissionsRoleId" id="permissionsRoleId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${roles}" var="item">
                        <c:if test="${item.roleId==permissions.permissionsRoleId}" var="result">
                            <option value="${item.roleId}" selected>${item.roleName}</option>
                        </c:if>
                        <c:if test="${!result}">
                            <option value="${item.roleId}">${item.roleName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                菜单:
            </td>
            <td>
                <select name="permissionsMenuId" id="permissionsMenuId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${menus}" var="item">
                        <c:if test="${item.menuId==permissions.permissionsMenuId}" var="result">
                            <option value="${item.menuId}" selected>${item.menuName}</option>
                        </c:if>
                        <c:if test="${!result}">
                            <option value="${item.menuId}">${item.menuName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                创建时间:
            </td>
            <td>
                <input type="input" name="permissionsCreateTime" value="<fmt:formatDate value="${permissions.permissionsCreateTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
                <input type="hidden" value="${permissions.permissionsId}" name="permissionsId"/>
                <input type = "submit" value="修改"/>
                <input type = "reset" value="重置"/>
                <a href="/permissions/permissionsAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
