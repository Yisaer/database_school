<%--
  Created by IntelliJ IDEA.
  User: Yisa
  Date: 2017/4/6
  Time: 上午9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./Common/JarLib.jsp"%>

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>教务管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="./lib/css/dasboard.css" rel="stylesheet">



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%
    session.removeAttribute("stat");
%>
<c:if test="${student == null}">
    <c:redirect url="index.jsp" />
</c:if>
<%@include file="./Common/headbar.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li id="Profile"><a href="#">资料总览</a></li>
                <li class="active" id="Elective"><a href="#">选课界面 <span class="sr-only">(current)</span></a></li>
                <li id="Course"><a href="#">课程一览</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">选课界面</h1>
            <h3> ${student.sName}</h3>
            <form class="form-horizontal" role="form" action="Elect" method="get">
                <div class="form-group">
                    <label for="cId" class="col-sm-2 control-label">课程号</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="cId" id="cId" placeholder="请输入课程号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="tId" class="col-sm-2 control-label">教师号</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="tId" id="tId" placeholder="请输入教师号">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="./lib/js/holder.min.js"></script>
<script>
    $('#Profile').click(function () {
        location.href="/student.jsp"
    });
    $('#Elective').click(function(){
        location.href="/elect.jsp";
    });
    $('#Course').click(function () {
        $.get('${pageContext.request.contextPath}' + '/course',function(data, status) {
            location.href="/course.jsp"
        });
    });
</script>

</body>
</html>