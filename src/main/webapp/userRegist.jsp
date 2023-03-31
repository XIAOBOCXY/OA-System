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
    <title>员工注册</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <style type="text/css">
        body{
            background-color: #87CEFA;
        }
    </style>
</head>
<body>
<div id = "login">
    <div id = "title">
        某某OA管理系统
    </div>
    <div style="border:1px solid honeydew; width:400px;height:30px; line-height:30px; text-align: center" id="message">提示消息</div>
    <form action="/login/regist" method="post">
        <table id="loginTable" style="margin-top:0px;">
            <tr>
                <td>用户名:&nbsp;</td>
                <%-- 保证用户的唯一性，文本框失去焦点时，验证用户名是否存在 --%>
                <td>
                    <input type= "text" name = "loginAccount" id = "userName" placeholder="请输入用户名"/>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;码:&nbsp;</td>
                <td>
                    <input type= "password" name = "loginPwd" id = "password" placeholder="请输入密码"/>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><input type= "submit" value="注册"/>
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form>
</div>
<script src="../js/jquery-1.8.3.min.js"></script>
<script>
    $(function(){
        $("#userName").blur(function () {
            //ajax 进行异步调用
            var name = $("#userName").val();//获得输入框的值
            $.ajax({
                url:'/login/isExist?username='+name,
                type:'get',
                success:function (res) {
                    //返回成功调用 res返回的内容，默认是json字符串，我们设置返回一个字符串
                    console.log(res);
                    if(res=="yes"){
                        $("#message").text("用户名可用");
                    }else{
                        $("#message").text("用户名已经存在");
                    }

                }
            })
        });
    });
</script>
</body>
</html>
