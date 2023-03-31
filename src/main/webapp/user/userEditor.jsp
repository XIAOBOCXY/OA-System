
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
    <title>修改用户信息</title>

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
<h1 class="title">首页  &gt;&gt;员工管理  &gt;&gt; 编辑用户信息 </h1>
<form action="/userinfo/editUser" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                员工编号:
            </td>
            <td>
                <input type = "text" name="userInfoNo" id="userInfoNo" value="${info.userInfoNo}" readonly disabled />
            </td>
        </tr>
        <tr>
            <td>
                员工姓名:
            </td>
            <td>
                <input type = "text" name="userName" id="userName" value="${info.userName}"/>
            </td>
        </tr>

        <tr>
            <td>
                邮箱:
            </td>
            <td>
                <input type = "text" name="userInfoEmail" id="userInfoEmail"  value="${info.userInfoEmail}"/>
            </td>
        </tr>

        <tr>
            <td>
                所在部门:
            </td>
            <td>
                <select name="userDeptId" id="userDeptId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${depts}" var="item">
                        <c:if test="${item.deptId==info.userDeptId}" var="result">
                            <option value="${item.deptId}" selected>${item.deptName}</option>
                        </c:if>
                        <c:if test="${!result}">
                            <option value="${item.deptId}">${item.deptName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                学历:
            </td>
            <td>
                <select name="userInfoEducation" id="userInfoEducation">
                    <c:if test="${info.userInfoEducation=='本科'}">
                        <option vaue="本科" selected>本科</option>
                    </c:if>
                    <c:if test="${info.userInfoEducation != '本科'}">
                        <option vaue="本科" >本科</option>
                    </c:if>

                    <c:if test="${info.userInfoEducation=='研究生'}">
                        <option vaue="研究生" selected>研究生</option>
                    </c:if>
                    <c:if test="${info.userInfoEducation != '研究生'}">
                        <option vaue="研究生" >研究生</option>
                    </c:if>

                    <c:if test="${info.userInfoEducation=='博士生'}">
                        <option vaue="博士生" selected>博士生</option>
                    </c:if>
                    <c:if test="${info.userInfoEducation != '博士生'}">
                        <option vaue="博士生" >博士生</option>
                    </c:if>

                    <c:if test="${info.userInfoEducation=='其他'}">
                        <option vaue="其他" selected>其他</option>
                    </c:if>
                    <c:if test="${info.userInfoEducation != '其他'}">
                        <option vaue="其他" >其他</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
                <input type="hidden" value="${info.userInfoId}" name="userInfoId"/>
                <input type = "submit" value="修改"/>
                <input type = "reset" value="重置"/>
                <a href="/user/userAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
