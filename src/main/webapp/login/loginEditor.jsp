
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
    <title>修改账户信息</title>

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
<h1 class="title">首页  &gt;&gt;账户管理  &gt;&gt; 编辑账户信息 </h1>
<form action="/login/editLogin" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                账户序号:
            </td>
            <td>
                <input type = "text" name="loginId" id="loginId" value="${login.loginId}" readonly disabled />
            </td>
        </tr>
        <tr>
            <td>
                账户姓名:
            </td>
            <td>
                <input type = "text" name="loginAccount" id="loginAccount" value="${login.loginAccount}"/>
            </td>
        </tr>

        <tr>
            <td>
                账户密码:
            </td>
            <td>
                <input type = "text" name="loginPwd" id="loginPwd" value="${login.loginPwd}"/>
            </td>
        </tr>

        <tr>
            <td>
                账户状态:
            </td>
            <td>
                <select name="loginStatus" id="loginStatus">
                    <c:if test="${login.loginStatus=='0'}">
                        <option value="0" selected>正常</option>
                    </c:if>
                    <c:if test="${login.loginStatus != '0'}">
                        <option value="0" >正常</option>
                    </c:if>

                    <c:if test="${login.loginStatus=='1'}">
                        <option value="1" selected>禁用</option>
                    </c:if>
                    <c:if test="${login.loginStatus !='1'}">
                        <option value="1" >禁用</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                错误次数:
            </td>
            <td>
                <input type = "text" name="loginError" id="loginError"  value="${login.loginError}"/>
            </td>
        </tr>
        <tr>
            <td>
                用户详细信息的Id:
            </td>
            <td>
                <select name="loginUserId" id="loginUserId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${infos}" var="item">
                        <c:if test="${item.userInfoId==login.loginUserId}" var="result">
                            <option value="${item.userInfoId}" selected>${item.userName}</option>
                        </c:if>
                        <c:if test="${!result}">
                            <option value="${item.userInfoId}">${item.userName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                账户角色:
            </td>
            <td>
                <select name="loginRoleId" id="loginRoleId">
                    <c:if test="${login.loginRoleId=='1'}">
                        <option value="1" selected>管理员</option>
                    </c:if>
                    <c:if test="${login.loginRoleId != '1'}">
                        <option value="1" >管理员</option>
                    </c:if>

                    <c:if test="${login.loginRoleId=='2'}">
                        <option value="2" selected>普通用户</option>
                    </c:if>
                    <c:if test="${login.loginRoleId !='2'}">
                        <option value="2" >普通用户</option>
                    </c:if>
                    <c:if test="${login.loginRoleId=='3'}">
                        <option value="3" selected>人事专员</option>
                    </c:if>
                    <c:if test="${login.loginRoleId !='3'}">
                        <option value="3" >人事专员</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                创建时间:
            </td>
            <td>
                <input type="input" name="loginCreateTime" value="<fmt:formatDate value="${login.loginCreateTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
                <input type="hidden" value="${login.loginId}" name="loginId"/>
                <input type = "submit" value="修改"/>
                <input type = "reset" value="重置"/>
                <a href="/login/loginAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
