

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
    <title>部门管理</title>

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
<h1 class="title">首页  &gt;&gt;部门管理 </h1>

<div class="add">
    <a href="/dept/addDeptPage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加部门</a>
</div>

<table class="deptInfo">
    <thead>
        <tr class="titleRow">
            <td>部门编号</td>
            <td>部门名称</td>
            <td>部门地址</td>
            <td>部门负责人</td>
            <td>操作列表</td>
        </tr>
    </thead>
   <tbody>
   <c:forEach items="${depts}" var="dept">
       <tr>
           <td>${dept.deptNo}</td>
           <td>${dept.deptName}</td>
           <td>${dept.deptAddress}</td>
           <td>${dept.deptUser}</td>
           <td>
               <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${dept.deptId}')">
               <a href="/dept/modifydept?deptId=${dept.deptId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
               <a href="/dept/detaildept?deptId=${dept.deptId}" target="contentPage"><img alt="" src="<%=basePath%>/img/detail.png" class="operateImg"></a>
           </td>
       </tr>
   </c:forEach>

   </tbody>
    <tfoot>
    <tr><td colspan="5">
        <p align="right" style="font-size: 12px;">当前第
            <input name="textfield2" type="text" size="1" value="${page1}" readonly="true"/>
            页 <a href="CommonAdminDelete.jsp?page=1">首页 </a>
            <a href="CommonAdminDelete.jsp?page=${page1-1}">上一页</a>
            <a href="CommonAdminDelete.jsp?page=${page1+1}"> 下一页</a>
            <a href="CommonAdminDelete.jsp?page=${pageCount}">末页</a>
            共<input name="total" type="text" size="1"readonly="true" value=${pageCount} />页
        </p>
    </td></tr>
    </tfoot>

</table>
</body>
</html>
