<%--
  Created by IntelliJ IDEA.
  User: Yisa
  Date: 2017/4/6
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">课程一览</h1>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>课程号</th>
                <th>课程名</th>
                <th>学分</th>
                <th>教师</th>
                <th>教师号</th>
                <th>开课时间</th>
                <th>学期</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ResList}" varStatus="status" var="item">
                <tr>
                    <td></td>
                    <td>${item.course.cId}</td>
                    <td>${item.course.cName}</td>
                    <td>${item.course.credit}</td>
                    <td>${item.teacher.tName}</td>
                    <td>${item.teacher.tId}</td>
                    <td>${item.open.cTime}</td>
                    <td>${item.open.semester}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
