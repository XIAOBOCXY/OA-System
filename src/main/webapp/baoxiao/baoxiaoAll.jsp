
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
    <title>报销管理</title>
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
<h1 class="title">首页  &gt;&gt;报销管理 </h1>

<div style="margin:0px auto; margin-left: 70px;">
    <form action="/baoxiao/searchBaoxiao" method="post">
        报销类型：<select name="baoxiaoType">
        <option value="0">---请选择---</option>
        option value="0">---请选择---</option>
        <!-- 加入所有可以查询到的二级部门， -->
        <c:forEach items="${baoxiaos}" var="item">--%>
            <c:if test="${item.baoxiaoType=='1'}">--%>
                <option value="${item.baoxiaoType}">差旅费</option>
            </c:if>
            <c:if test="${item.baoxiaoType=='2'}">--%>
                <option value="${item.baoxiaoType}">招待费</option>
            </c:if>
            <c:if test="${item.baoxiaoType=='3'}">--%>
                <option value="${item.baoxiaoType}">办公费</option>
            </c:if>
        </c:forEach>
    </select>
        申请状态：<select name="baoxiaoStatus">
        <option value="0">---请选择---</option>
        <c:forEach items="${baoxiaos}" var="item">--%>
            <c:if test="${item.baoxiaoStatus=='1'}">--%>
                <option value="${item.baoxiaoStatus}">草稿</option>
            </c:if>
            <c:if test="${item.baoxiaoStatus=='2'}">--%>
                <option value="${item.baoxiaoStatus}">提交</option>
            </c:if>
        </c:forEach>
    </select>
        <input type="submit" value="查询"/>
    </form>
</div>

<div class="add" style="margin-top:20px;">
    <a href="/baoxiao/addBaoxiaoPage" target="contentPage"><img alt="" src="<%=basePath%>/img/add.png" width="18px" height="18px">添加请假</a>
</div>



<table class="holidaydeptInfo">
    <tr class="titleRow">
        <td>报销编号</td>
        <td>申请人</td>
        <td>报销类型</td>
        <td>金额</td>
        <td>申请时间</td>
        <td>申请状态</td>
        <td>操作列表</td>
    </tr>
    <c:forEach items="${baoxiaos}" var="item">
        <tr>
            <td>${item.baoxiaoNo}</td>
            <td>
                <c:forEach items="${infos}" var="info">
                    <c:if test="${info.userInfoId == item.baoxiaoUserId}">${info.userName}</c:if>
                </c:forEach>
            </td>
            <td><c:if test="${item.baoxiaoType=='1'}">差旅费</c:if>
                <c:if test="${item.baoxiaoType=='2'}">招待费</c:if>
                <c:if test="${item.baoxiaoType=='3'}">公共费</c:if>
            </td>
            <td>${item.baoxiaoMoney}</td>
            <td>
                <fmt:formatDate value="${item.baoxiaoCreateTime}" pattern="yyyy-MM-dd" />
            </td> <!-- 日期格式问题 -->
            <td><c:if test="${item.baoxiaoStatus=='1'}">草稿</c:if>
                <c:if test="${item.baoxiaoStatus=='2'}">提交</c:if>
            </td>

            <td>
                <img alt="" src="<%=basePath%>/img/delete.png" class="operateImg" onclick="del('${item.baoxiaoId}')">
                <a href="/baoxiao/modifybaoxiao?baoxiaoId=${item.baoxiaoId}" target="contentPage"><img alt="" src="<%=basePath%>/img/edit.png" class="operateImg" ></a>
                <a href="/baoxiao/detailbaoxiao?baoxiaoId=${item.baoxiaoId}" target="contentPage"><img alt="" src="<%=basePath%>/img/detail.png" class="operateImg"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script>
    function del(id){
        if(confirm("确定要删除该报销吗？")){
            //alert("是");
            window.location.href="/baoxiao/deletebaoxiao?baoxiaoId="+id;
        }else{
            // alert("否");//什么也不做
        }
    }
</script>
</body>
</html>
