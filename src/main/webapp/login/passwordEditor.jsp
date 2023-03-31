
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
    <title>密码重置</title>

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
<h1 class="title">首页  &gt;&gt;密码重置  </h1>
<form action="/login/editpassword" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                账户姓名:
            </td>
            <td>
                <select name="loginId" id="loginId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${logins}" var="item">
                        <option value="${item.loginId}">${item.loginAccount}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                原密码:
            </td>
            <td>
                <input type = "text" name="oldloginPwd" id="oldloginPwd"/>
            </td>
        </tr>

        <tr>
            <td>
                新密码:
            </td>
            <td>
                <input type = "text" name="newloginPwd1" id="newloginPwd1"/>
            </td>
        </tr>
        <tr>
            <td>
                确认密码:
            </td>
            <td>
                <input type = "text" name="newloginPwd2" id="newloginPwd2"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
<%--                <input type="hidden" value="${}" name="loginId"/>--%>
                <input type = "submit" value="修改"/>
<%--                <a href="/login/loginAll.jsp" target="contentPage"><input type="button" value="返回"></a>--%>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
