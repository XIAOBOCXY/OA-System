
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
    <title>修改报销信息</title>

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
<h1 class="title">首页  &gt;&gt;报销管理  &gt;&gt; 编辑报销信息 </h1>
<form action="/baoxiao/editBaoxiao" method="post">

    <table id = "deptEditTable">
        <tr>
            <td>
                报销序号:
            </td>
            <td>
                <input type = "text" name="baoxiaoId" id="baoxiaoId" value="${baoxiao.baoxiaoId}" readonly disabled />
            </td>
        </tr>
        <tr>
            <td>
                报销编号:
            </td>
            <td>
                <input type = "text" name="baoxiaoNo" id="baoxiaoNo" value="${baoxiao.baoxiaoNo}"/>
            </td>
        </tr>

        <tr>
            <td>
                申请人:
            </td>
            <td>
                <select name="baoxiaoUserId" id="baoxiaoUserId">
                    <option value="0">-- 请选择 -- </option>
                    <c:forEach items="${infos}" var="item">
                        <c:if test="${item.userInfoId==baoxiao.baoxiaoUserId}" var="result">
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
                报销的类型:
            </td>
            <td>
                <select name="baoxiaoType" id="baoxiaoType">
                    <c:if test="${baoxiao.baoxiaoType=='1'}">
                        <option value="1" selected>差旅费</option>
                    </c:if>
                    <c:if test="${baoxiao.baoxiaoType != '1'}">
                        <option value="1" >差旅费</option>
                    </c:if>

                    <c:if test="${baoxiao.baoxiaoType=='2'}">
                        <option value="2" selected>招待费</option>
                    </c:if>
                    <c:if test="${baoxiao.baoxiaoType !='2'}">
                        <option value="2" >招待费</option>
                    </c:if>

                    <c:if test="${baoxiao.baoxiaoType=='3'}">
                        <option value="3" selected>办公费</option>
                    </c:if>
                    <c:if test="${baoxiao.baoxiaoType != '3'}">
                        <option value="3" >办公费</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                报销摘要:
            </td>
            <td>
                <input type = "text" name="baoxiaoTest" id="baoxiaoTest"  value="${baoxiao.baoxiaoTest}"/>
            </td>
        </tr>
        <tr>
            <td>
                报销金额:
            </td>
            <td>
                <input type = "text" name="baoxiaoMoney" id="baoxiaoMoney"  value="${baoxiao.baoxiaoMoney}"/>
            </td>
        </tr>
        <tr>
            <td>
                报销申请时间:
            </td>
            <td>
                <input type="input" name="baoxiaoCreateTime" value="<fmt:formatDate value="${baoxiao.baoxiaoCreateTime}" pattern="yyyy-MM-dd"/>" />
            </td>
        </tr>
        <tr>
            <td>
                报销申请状态:
            </td>
            <td>
                <select name="baoxiaoStatus" id="baoxiaoStatus">
                    <c:if test="${baoxiao.baoxiaoStatus=='1'}">
                        <option value="1" selected>草稿</option>
                    </c:if>
                    <c:if test="${baoxiao.baoxiaoStatus != '1'}">
                        <option value="1">草稿</option>
                    </c:if>

                    <c:if test="${baoxiao.baoxiaoStatus=='2'}">
                        <option value='2' selected>提交</option>
                    </c:if>
                    <c:if test="${baoxiao.baoxiaoStatus != '2'}">
                        <option value='2' >提交</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <!-- 隐藏表单域，存放主键 -->
                <input type="hidden" value="${baoxiao.baoxiaoId}" name="baoxiaoId"/>
                <input type = "submit" value="修改"/>
                <input type = "reset" value="重置"/>
                <a href="/baoxiao/baoxiaoAll.jsp" target="contentPage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>


</form>
</body>
</html>
