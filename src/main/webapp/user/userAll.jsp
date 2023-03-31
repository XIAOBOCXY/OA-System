
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
    <title>员工管理</title>
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
<h1 class="title">首页  &gt;&gt;员工管理 </h1>

        <div style="margin:0px auto; margin-left: 70px;">
            <form action="/userinfo/searchUser" method="post">
                姓名:<input type="text" name="userName" placeholder="请输入姓名">&nbsp;&nbsp;&nbsp;&nbsp;
                部门：<select name="deptId">
                <option value="0">---请选择---</option>
                <!-- 加入所有可以查询到的二级部门， -->
                <c:forEach items="${depts}" var="item">

                    <option value="${item.deptId}">${item.deptName}</option>
                </c:forEach>
            </select>
                <input type="submit" value="查询"/>
            </form>
        </div>

        <div class="add" style="margin-top:20px;">
            <a href="/userinfo/addUserInfoPage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加员工</a>
        </div>



<table class="deptInfo">
    <tr class="titleRow">
        <td>员工编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>所属部门</td>
        <td>入职时间</td>
        <td>操作列表</td>
    </tr>
    <c:forEach items="${infos}" var="item">
      <tr>
        <td>${item.userInfoNo}</td>
        <td>${item.userName}</td>
        <td>${item.userInfoSex}</td>
        <td> <!-- 部门id如何变成部门名称 -->
            <c:forEach items="${depts}" var="dept">
                <c:if test="${dept.deptId == item.userDeptId}">${dept.deptName}</c:if>
            </c:forEach>
        </td>

        <!--
        https://blog.csdn.net/lydong_/article/details/79812428
        -->
        <td>
            <fmt:formatDate value="${item.userInfoEntryTime}" pattern="yyyy-MM-dd" />
        </td> <!-- 日期格式问题 -->
        <td>
            <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${item.userInfoId}')">
            <a href="/userinfo/modifyUser?userId=${item.userInfoId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
            <a href="/userinfo/detailUser?userId=${item.userInfoId}" target="contentPage"><img alt="" src="<%=basePath%>/img/detail.png" class="operateImg"></a>
        </td>
      </tr>
    </c:forEach>
</table>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id){
        if(confirm("确定要删除该用户吗？")){
            // alert("是");
            //先判断能不能删除
            $.ajax({
                url:'/userinfo/isDeleteUser?userId='+id ,
                type:'get',
                success:function(res){
                    if(res=="ok"){
                        //删除
                        window.location.href="/userinfo/deleteUser?userId="+id;
                    }else{
                        alert("这个员工还有一些相关关联数据，不能删除");
                    }
                }
            });

        }else{
            // alert("否");//什么也不做
        }
    }
</script>
</body>
</html>
