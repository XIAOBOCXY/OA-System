

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
    <title>用户登录</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/login.css">

    <style type="text/css">
        body{
            background-color: #87CEFA;
        }
    </style>
</head>

<body>
<div id = "login">
    <div id = "title">
        OA管理系统
    </div>
    <div style="border:1px solid honeydew; width:400px;height:30px; line-height:30px; text-align: center" id="message">${msg}</div>
    <form action="/login/loginVo" method="post" id="form1">
        <table id="loginTable" style="margin-top:0px;">
            <tr>
                <td>用户名:&nbsp;</td>
                <td>
                    <input type= "text" name = "loginAccount" id = "userName"/>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;码:&nbsp;</td>
                <td>
                    <input type= "password" name = "loginPwd" id = "password"/>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr >
                <td>验证码:&nbsp;</td>
                <td>
                    <input type= "text" name = "code" id = "code" style="width:80px;"/><img src="/captcha" id="imageCode" onclick="changeImage()" width="130" height="35" align="middle"/>
                </td>
                <td>
                    &nbsp;
                </td>
            </tr>
            <tr >
                <td>身&nbsp;&nbsp;&nbsp;份:&nbsp;</td>
                <td>
                    <label><input type= "radio" name = "role" value="admin" onclick="changeRole('admin')"/>管理员</label>&nbsp;&nbsp;
                    <label><input type= "radio" name = "role" value="worker" onclick="changeRole('worker')"/>员工</label>&nbsp;&nbsp;
                    <label><input type= "radio" name = "role" value="accounting" onclick="changeRole('accounting')"/>财务</label>&nbsp;&nbsp;
                    <label><input type= "radio" name = "role" value="student" onclick="changeRole('student')" checked="checked"/>学生</label>&nbsp;&nbsp;
                </td>
                <td>
                    &nbsp;
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2">
                    <input type= "button" value="登&nbsp;录" onclick="mySubmit()"  class="btn"/> &nbsp;&nbsp;<a href="/page/userRegist">员工注册</a>
                </td>
            </tr>

        </table>
    </form>
</div>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    var role="student";
    //修改登录方式
    function changeRole(val){
        role=val;
    }
    //如果访问不同的url,可以自定义提交方式，我们这边都是同一个登录，然后确定不同的角色，是不需要的
    function mySubmit(){
       var f = document.getElementById("form1");
       if(role=="admin"){
           f.action="/admin/login";
       }else if(role=="worker"){
           f.action="/login/loginVo";
       }else if(role=="accounting"){
           f.action="/login/loginVo";
       }else if(role=="student"){
           f.action="/login/loginVo";
       }
       f.submit();
    }
    function changeImage(){
        //第三方验证码的网址
        //https://www.jianshu.com/p/8a853a13159b
        var img = document.getElementById("imageCode");
        var date = new Date();
        img.src="/captcha?id="+date.getTime();
    }
</script>
</body>
</html>
