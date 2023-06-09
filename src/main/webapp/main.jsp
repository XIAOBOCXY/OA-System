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
    <title>首页内容</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
    <script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>

    <style type="text/css">
        .hide{
            display: none;

        }
    </style>
    <script type="text/javascript">
        $(function(){
            //找到所有的li,且class=menu
            //alert($("li[class='menu']").length);


            //存在的问题：一级菜单和二级菜单能正常的显示与隐藏，但是当点击二级菜单，发现二级菜单也跟着隐藏

            //吸取一个经验：在网页元素排版时，要兼顾后期的js操作
            //一个合理的网页布局，会让js获取元素时非常遍历，否则就很痛苦
            /**
             $("li[class='menu']").each(function(){
   		  	  $(this).click(function(){
   		  	      $(this).children(".hide").slideToggle();
   		  	  });

   		  });
             */

            //对所有的span标签设置单击事件

            //alert($("span").length);  4个

            //alert($("li[class='menu'] span").length);

            $("li[class='menu'] span").each(function(){
                $(this).click(function(){
                    //this代表的是span
                    $(this).siblings(".hide").slideToggle();

                });

            });

        });

    </script>


</head>

<body>
<div id = "mainDiv">
    <div id = "header">
        <div id = "logoDiv" class="lft">
            浙江万里学院
        </div>
        <div id = "userD0iv" class="rft">
            ${info.userName}
        </div>
    </div>
    <div id = "welcomeDiv">
        欢迎使用OA管理系统
    </div>


    <div id = "contentDiv">
        <div id = "content-left" class="lft">
            <ul>

                <li class="menu">
                    <span>人事管理</span>
                    <ul class="hide">
                        <c:forEach items="${second}" var="item">
                            <c:if test="${item.menuParentId==1}">
                                <li class="menu-sub" ><a href="${item.menuHrefUrl}"  id="deptManager"   target="contentPage">${item.menuName}</a></li>
                            </c:if>

                        </c:forEach>
                        <%--<li class="menu-sub" ><a href="dept/dept.html"  id="deptManager"   target="contentPage">部门管理</a></li>--%>
                        <%--<li class="menu-sub">员工管理</li>--%>
                        <%--<li class="menu-sub">请假管理</li>--%>
                    </ul>

                </li>

                <li class="menu">
                    <span>财务管理</span>
                    <ul  class="hide">
                        <c:forEach items="${second}" var="item">
                            <c:if test="${item.menuParentId==2}">
                                <li class="menu-sub" ><a href="${item.menuHrefUrl}"  id="deptManager"   target="contentPage">${item.menuName}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>

                </li>
                <li class="menu">
                    <span>系统管理</span>
                    <ul class="hide">
                        <c:forEach items="${second}" var="item">
                            <c:if test="${item.menuParentId==3}">
                                <li class="menu-sub" ><a href="${item.menuHrefUrl}"  id="deptManager"   target="contentPage">${item.menuName}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>

                </li>

            </ul>


        </div>

        <div id = "content-right" class="rft">
            <iframe src="" name="contentPage" scrolling="yes" frameborder="0" width="1300px" height="580px">
            </iframe>
        </div>
    </div>

    <div id = "footer">
        <span>&copy;版权归属OA管理系统</span>
    </div>

</div>

</body>
</html>
