
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
    <title>修改部门信息</title>

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
<h1 class="title">首页  &gt;&gt;部门管理  &gt;&gt; 编辑部门信息 </h1>
<form action="/dept/editDept" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                部门编号:
            </td>
            <td>
                <input type = "text" name="deptNo" id="deptNo" value="${dept.deptNo}" readonly disabled/>
            </td>
        </tr>
        <tr>
            <td>
                部门名称:
            </td>
            <td>
                <input type = "text" name="deptName" id="deptName" value="${dept.deptName}"/>
            </td>
        </tr>
        <tr>
            <td>
                部门负责人:
            </td>
            <td>
                <input type = "text" name="deptUser" id="deptUser"  value="${dept.deptUser}"/>
            </td>
        </tr>
        <tr>
            <td>
                部门地址:
            </td>
            <td>
                <input type="input" name="deptAddress" id="deptAddress" value="${dept.deptAddress}"/>
            </td>
        </tr>


        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
                <input type="hidden" value="${dept.deptId}" name="deptId"/>
                <input type = "submit" value="修改"/>
                <input type = "reset" value="重置"/>
                <a href="/dept/deptAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
