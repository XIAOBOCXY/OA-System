

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
    <title>新增员工信息</title>
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
<h1 class="title">首页  &gt;&gt;员工管理  &gt;&gt; 添加用户 </h1>
<form action="/userinfo/addUser" method="post" id="form1">

    <table id = "deptEditTable">
        <tr>
            <td>
                员工编号:
            </td>
            <td>
                <input type = "text" name="userInfoNo" id="userInfoNo"/><span id="showIsExist"></span>
            </td>
        </tr>
        <tr>
            <td>
                员工姓名:
            </td>
            <td>
                <input type = "text" name="userName" id="userName"/>
            </td>
        </tr>

        <tr>
            <td>
                部门名称:
            </td>
            <td>
                <select name="userDeptId" id="userDeptId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${depts}" var="item">
                        <option value="${item.deptId}">${item.deptName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                员工性别:
            </td>
            <td>
                <label><input type = "radio" name="userInfoSex" value="男" checked/>男</label> &nbsp;&nbsp;
                <label><input type = "radio" name="userInfoSex" value="女" />女</label>
            </td>
        </tr>
        <tr>
            <td>
                员工学历:
            </td>
            <td>
                <select name="userInfoEducation" id="userInfoEducation">
                    <option vaue="本科" selected>本科</option>
                    <option vaue="研究生">研究生</option>
                    <option vaue="博士生">博士生</option>
                    <option vaue="其他">其他</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                邮箱:
            </td>
            <td>
                <input type = "email" name="userInfoEmail" id="userInfoEmail"/>
            </td>
        </tr>

        <tr>
            <td>
                电话:
            </td>
            <td>
                <input type = "text" pattern="^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$" name="userInfoPhone" id="userInfoPhone"/>
            </td>
        </tr>
        <tr>
            <td>
                入职时间:
            </td>
            <td>
                <input type = "text" name="userInfoEntryTime1" id="userInfoEntryTime"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type = "button" id="btnSubmit" value="添加"/>
                <input type = "reset" value="重置"/>
<%--                <a href="dept.html" target="contentPage"><input type="button" value="返回"></a>--%>
                <a href="/user/userAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>

</form>
<script>
    var isSubmit=false;
    $(function(){
        $("#btnSubmit").click(function () {
            var form = $("#form1");
            if(isSubmit){
                //提交
                form.submit();
            }else{
                alert("部分数据有误，请检查后再添加员工信息");
            }
        });
        //文本框失去焦点时间，验证员工编号是否存在
        $("#userInfoNo").blur(function(){
            //获得文本框中的内容
            var value = $("#userInfoNo").val();
            $.ajax({
                url:'/userinfo/isExistNo?no='+value,
                type:'get',
                success:function (res) {
                   console.log(res);
                    var span= $("#showIsExist");
                   if('success'==res){
                       span.html("<font color='green'>√</font>");
                       isSubmit = true;
                   }else{
                       span.html("<font color='red'>×</font>");
                       isSubmit=false;
                   }
                }
            });
        });
    });
</script>
</body>
</html>

