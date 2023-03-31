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
        <title>账户管理</title>
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
<h1 class="title">首页  &gt;&gt;账户管理 </h1>

<div style="margin:0px auto; margin-left: 70px;">
    <form action="/login/searchLogin" method="post">
        账户:<input type="text" name="loginAccount" placeholder="请输入账号">&nbsp;&nbsp;&nbsp;&nbsp;
        账号状态：
        <select name="loginStatus">
        <!-- 加入所有可以查询到的二级部门， -->
            <option value="0">---请选择---</option>
        <c:forEach items="${logins}" var="item">--%>
            <c:if test="${item.loginStatus=='0'}">--%>
                <option value="${item.loginStatus}">正常</option>
            </c:if>
            <c:if test="${item.loginStatus=='1'}">--%>
                <option value="${item.loginStatus}">禁用</option>
            </c:if>
            <%--            <option value="${item.holidayHolidayStatus}">${item.holidayHolidayStatus}</option>--%>
        </c:forEach>
        </select>
        角色：<select name="loginRoleId">
        <option value="0">---请选择---</option>
        <c:forEach items="${roles}" var="item">
            <option value="${item.roleId}">${item.roleName}</option>
        </c:forEach>
    </select>
        <input type="submit" value="查询"/>
    </form>
</div>

<div class="add" style="margin-top:20px;">
    <a href="/login/addHLoginPage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加账户</a>
</div>



<table class="holidaydeptInfo">
    <tr class="titleRow">
        <td>账号</td>
        <td>员工姓名</td>
        <td>状态</td>
        <td>角色</td>
        <td>操作列表</td>
    </tr>
    <c:forEach items="${logins}" var="item">
        <tr>
            <td>${item.loginId}</td>
            <td>${item.loginAccount}</td>
            <td><c:if test="${item.loginStatus=='0'}">正常</c:if>
                <c:if test="${item.loginStatus=='1'}">禁用</c:if>
            </td>
            <td>
                <c:forEach items="${roles}" var="role">
                    <c:if test="${role.roleId == item.loginRoleId}">${role.roleName}</c:if>
                </c:forEach>
            </td>
            <td>
                <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${item.loginId}')">
                <a href="/login/modifylogin?loginId=${item.loginId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
        </tr>
    </c:forEach>
</table>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id){
        if(confirm("确定要删除该账户吗？")){
            // alert("是");
            window.location.href="/login/deletelogin?loginId="+id;
        }else{
            // alert("否");//什么也不做
        }
    }
</script>
</body>
</html>


