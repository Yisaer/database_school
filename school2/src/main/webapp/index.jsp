
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.lang.*"%>
<%
  System.gc();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>教务管理系统</title>

  <!-- Bootstrap -->
  <link href="./lib/css/bootstrap.min.css" rel="stylesheet">
  <link href="./lib/css/style.css" rel="stylesheet">
  <link href="./lib/css/signin.css" rel="stylesheet">
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="./lib/js/html5shiv.js"></script>
  <script src="./lib/js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<%
    session.invalidate();
%>

<%@include file="./Common/headbar.jsp"%>
<div class="container">

  <form class="form-signin" action="Login">
    <h2 class="form-signin-heading">登录界面</h2>
    <label for="inputID" class="sr-only">用户名</label>
    <input type="text" id="inputID" class="form-control" placeholder="请输入用户名" required autofocus id="username" name="username">
    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required id="password" name="password">
    <div class="checkbox">
    </div>
    <div>
      ${alert}
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>

</div> <!-- /container -->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="./lib/js/jquery-1.11.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./lib/js/bootstrap.min.js"></script>

</body>
</html>