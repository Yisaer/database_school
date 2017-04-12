<%--
  Created by IntelliJ IDEA.
  User: StevenMing
  Date: 2017/4/2
  Time: 12:30
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

<c:if test="${teacher == null}">
    <c:redirect url="index.jsp" />
</c:if>
<%
    session.removeAttribute("admin");
    session.removeAttribute("student");
%>
<%@include file="./Common/headbar.jsp"%>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active" id="Profile"><a href="#">资料总览<span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">教师界面</h1>
            <h3>你好, ${teacher.tName}</h3>
            <h2 class="sub-header">上课记录</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>学期</th>
                        <th>课程号</th>
                        <th>学生</th>
                        <th>平时成绩</th>
                        <th>考试成绩</th>
                        <th>总评成绩</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${electiveList}" varStatus="status" var="item">
                        <tr>
                            <td></td>
                            <td>${item.semester}</td>
                            <td>${item.cId}</td>
                            <td>${item.sId}</td>
                            <td>${item.pscj}</td>
                            <td>${item.kscj}</td>
                            <td>${item.zpcj}</td>
                            <td><a href="/teacher.jsp?idx=${status.index}">修改成绩</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%-- ↓↓成绩修改↓↓ --%>
            <c:if test="${param.get('idx') != null}">
                <h2 class="sub-header">成绩修改</h2>
                <form class="form-horizontal" role="form" action="Update" method="get">
                    <c:forEach items="${electiveList}" varStatus="status" var="item" begin="${param.idx}" end="${param.idx}">
                        <div class="form-group">
                            <label for="semester" class="col-sm-2 control-label">课程号</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="semester" id="semester" value="${item.semester}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cId" class="col-sm-2 control-label">课程号</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="cId" id="cId" value="${item.cId}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sId" class="col-sm-2 control-label">学生号</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="sId" id="sId" value="${item.sId}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pscj" class="col-sm-2 control-label">平时成绩</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="pscj" id="pscj" value="${item.pscj}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="kscj" class="col-sm-2 control-label">考试成绩</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="kscj" id="kscj" value="${item.kscj}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Percentage" class="col-sm-2 control-label">平时成绩占比</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="Percentage" id="Percentage" placeholder="请输入小数,如: 0.5" ">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </c:forEach>
                </form>
            </c:if>
            <%-- ↑↑成绩修改↑↑ --%>
            <c:if test="${param.get('idx') == null}">
                <h3>${updateStat}</h3>
            </c:if>
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
        location.href="/teacher.jsp"
    });
</script>

</body>
</html>
