
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
    <title>请假管理</title>
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
<h1 class="title">首页  &gt;&gt;请假管理 </h1>

<div style="margin:0px auto; margin-left: 70px;">
    <form action="/holiday/searchHoliday" method="post">
        申请人:<input type="text" name="userName" placeholder="请输入姓名">&nbsp;&nbsp;&nbsp;&nbsp;
        请假类型：<select name="holidayTypeId">
        <option value="0">---请选择---</option>
        <c:forEach items="${sysconfigs}" var="item">
            <option value="${item.configId}">${item.configType}</option>
        </c:forEach>
    </select>
        申请状态：<select name="holidayHolidayStatus">
        <option value="0">---请选择---</option>
        <!-- 加入所有可以查询到的二级部门， -->
        <c:forEach items="${holidays}" var="item">--%>
            <c:if test="${item.holidayHolidayStatus=='1'}">--%>
               <option value="${item.holidayHolidayStatus}">草稿</option>
            </c:if>
            <c:if test="${item.holidayHolidayStatus=='2'}">--%>
                <option value="${item.holidayHolidayStatus}">提交</option>
            </c:if>
<%--            <option value="${item.holidayHolidayStatus}">${item.holidayHolidayStatus}</option>--%>
        </c:forEach>
    </select>
        <input type="submit" value="查询"/>
    </form>
</div>

<div class="add" style="margin-top:20px;">
    <a href="/holiday/addHolidayPage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加请假</a>
</div>



<table class="holidaydeptInfo">
    <tr class="titleRow">
        <td>请假编号</td>
        <td>申请人</td>
        <td>请假类型</td>
        <td>请假事由</td>
        <td>开始时间</td>
        <td>结束时间</td>
        <td>申请状态</td>
        <td>提交时间</td>
        <td>操作列表</td>
    </tr>
    <c:forEach items="${holidays}" var="item">
        <tr>
            <td>${item.holidayNo}</td>
            <td>
                <c:forEach items="${infos}" var="info">
                    <c:if test="${info.userInfoId == item.holidayUserId}">${info.userName}</c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${sysconfigs}" var="sysconfig">
                    <c:if test="${sysconfig.configId == item.holidayTypeId}">${sysconfig.configType}</c:if>
                </c:forEach>
            </td>
            <td>${item.holidayBz}</td>
            <td>
                <fmt:formatDate value="${item.holidayStartTime}" pattern="yyyy-MM-dd" />
            </td> <!-- 日期格式问题 -->
            <td>
                <fmt:formatDate value="${item.holidayEndTime}" pattern="yyyy-MM-dd" />
            </td> <!-- 日期格式问题 -->
<%--            <td>${item.holidayHolidayStatus}</td>--%>
            <td><c:if test="${item.holidayHolidayStatus=='1'}">草稿</c:if>
            <c:if test="${item.holidayHolidayStatus=='2'}">提交</c:if> </td>
            <td>
                <fmt:formatDate value="${item.holidayUpdateTime}" pattern="yyyy-MM-dd" />
            </td> <!-- 日期格式问题 -->

            <td>
                <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${item.holidayId}')">
                <a href="/holiday/modifyholiday?holidayId=${item.holidayId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
                <a href="/holiday/detailholiday?holidayId=${item.holidayId}" target="contentPage"><img alt="" src="<%=basePath%>/img/detail.png" class="operateImg"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id){
        if(confirm("确定要删除该请假信息吗？")){
            // alert("是");
            window.location.href="/holiday/deleteholiday?holidayId="+id;
        }else{
            // alert("否");//什么也不做
        }
    }
</script>
</body>
</html>
