
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
    <title>修改请假信息</title>

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
<h1 class="title">首页  &gt;&gt;请假管理  &gt;&gt; 编辑请假信息 </h1>
<form action="/holiday/editHoliday" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                请假序号:
            </td>
            <td>
                <input type = "text" name="holidayId" id="holidayId" value="${holiday.holidayId}" readonly disabled />
            </td>
        </tr>
        <tr>
            <td>
                请假条编号:
            </td>
            <td>
                <input type = "text" name="holidayNo" id="holidayNo" value="${holiday.holidayNo}"/>
            </td>
        </tr>

        <tr>
            <td>
                申请人:
            </td>
            <td>
                <select name="holidayUserId" id="holidayUserId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${infos}" var="item">
                        <c:if test="${item.userInfoId==holiday.holidayUserId}" var="result">
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
                请假的类型:
            </td>
            <td>
                <select name="holidayTypeId" id="holidayTypeId">
                    <c:if test="${holiday.holidayTypeId=='1'}">
                        <option value="1" selected>事假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId != '1'}">
                        <option value="1" >事假</option>
                    </c:if>

                    <c:if test="${holiday.holidayTypeId=='2'}">
                        <option value="2" selected>婚假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId !='2'}">
                        <option value="2" >婚假</option>
                    </c:if>

                    <c:if test="${holiday.holidayTypeId=='3'}">
                        <option value="3" selected>病假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId != '3'}">
                        <option value="3" >病假</option>
                    </c:if>

                    <c:if test="${holiday.holidayTypeId=='4'}">
                        <option value="4" selected>产假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId != '4'}">
                        <option value="4" >产假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId=='5'}">
                        <option value="5" selected>丧假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId != '5'}">
                        <option value="5" >丧假</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId=='6'}">
                        <option value="6" selected>出差</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId !='6'}">
                        <option value="6" >出差</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId=='7'}">
                        <option value="7" selected>住宿</option>
                    </c:if>
                    <c:if test="${holiday.holidayTypeId !='7'}">
                        <option value="7" >住宿</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                请假人理由:
            </td>
            <td>
                <input type = "text" name="holidayBz" id="holidayBz"  value="${holiday.holidayBz}"/>
            </td>
        </tr>
        <tr>
            <td>
                开始时间:
            </td>
            <td>
                <input type="input" name="holidayStartTime" value="<fmt:formatDate value="${holiday.holidayStartTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>
        <tr>
            <td>
                结束时间:
            </td>
            <td>
                <input type="input" name="holidayEndTime" value="<fmt:formatDate value="${holiday.holidayEndTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>
        <tr>
            <td>
                请假条状态:
            </td>
            <td>
                <select name="holidayHolidayStatus" id="holidayHolidayStatus">
                    <c:if test="${holiday.holidayHolidayStatus=='1'}">
                        <option value="1" selected>草稿</option>
                    </c:if>
                    <c:if test="${holiday.holidayHolidayStatus != '1'}">
                        <option value="1">草稿</option>
                    </c:if>

                    <c:if test="${holiday.holidayHolidayStatus=='2'}">
                        <option value='2' selected>提交</option>
                    </c:if>
                    <c:if test="${holiday.holidayHolidayStatus != '2'}">
                        <option value='2' >提交</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                审批人:
            </td>
            <td>
                <select name="holidayShenpiUserId" id="holidayShenpiUserId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${infos}" var="item">
                        <c:if test="${item.userInfoId==holiday.holidayShenpiUserId}" var="result">
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
                创建时间:
            </td>
            <td>
                <input type="input" name="holidayCreateTime" value="<fmt:formatDate value="${holiday.holidayCreateTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>
        <tr>
            <td>
                修改时间:
            </td>
            <td>
                <input type="input" name="holidayUpdateTime" value="<fmt:formatDate value="${holiday.holidayUpdateTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
                <input type="hidden" value="${holiday.holidayId}" name="holidayId"/>
                <input type = "submit" value="修改"/>
                <input type = "reset" value="重置"/>
                <a href="/holiday/holidayAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
