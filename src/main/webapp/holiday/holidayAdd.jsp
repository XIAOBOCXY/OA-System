

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
<h1 class="title">首页  &gt;&gt;请假管理  &gt;&gt; 添加请假 </h1>
<form action="/holiday/addHoliday" method="post" id="form1">

    <table id = "deptEditTable">
        <tr>
            <td>
                请假序号:
            </td>
            <td>
                <input type = "text" name="holidayId" id="holidayId" /><span id="showIsExist"></span>
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td>--%>
<%--                请假条编号:--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <input type = "text" name="holidayNo" id="holidayNo"/>--%>
<%--            </td>--%>
<%--        </tr>--%>

        <tr>
            <td>
                申请人:
            </td>
            <td>
                <select name="holidayUserId" id="holidayUserId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${infos}" var="item">
                            <option value="${item.userInfoId}">${item.userName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                请假的类型:
            </td>
            <td>
                <select name="holidayTypeId" id="holidayTypeId">
                    <option value="0">-- 请选择 -- </option>
                        <option value="1" >事假</option>
                        <option value="2" >婚假</option>
                        <option value="3" >病假</option>
                        <option value="4" >产假</option>
                        <option value="5" >丧假</option>
                        <option value="6" >出差</option>
                        <option value="7" >住宿</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                请假人理由:
            </td>
            <td>
                <input type = "text" name="holidayBz" id="holidayBz"  />
            </td>
        </tr>
        <tr>
            <td>
                开始时间:
            </td>
            <td>
                <input type="input" name="holidayStartTime" />
            </td>
        </tr>
        <tr>
            <td>
                结束时间:
            </td>
            <td>
                <input type="input" name="holidayEndTime"  />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type = "button" id="btnSubmit" value="添加"/>
                <input type = "reset" value="重置"/>
                <a href="/holiday/holidayAll.jsp" target="contentPage"><input type="button" value="返回"></a>
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
                alert("部分数据有误，请检查后再添加请假信息");
            }
        });
        //文本框失去焦点时间，验证员工编号是否存在
        $("#holidayId").blur(function(){
            //获得文本框中的内容
            var value = $("#holidayId").val();
            $.ajax({
                url:'/holiday/isExistNo?no='+value,
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

