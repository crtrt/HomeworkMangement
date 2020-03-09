<%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="nav" >
    <ul>
        <li><a href="/TeacherJSP/readHomework.jsp">查看作业</a></li>
        <li><a href="/TeacherJSP/addHomework.jsp">添加作业</a></li>
        <li><a href="/TeacherJSP/addStudent.jsp">添加学生</a></li>
        <li><a href="../index.jsp">返回首页</a></li>
    </ul>
</div>
<style>
    #nav>ul>li{
        float:left;
        margin-left:50px;

    }
    #nav{
        font-size: 20px;
        font-family: 宋体;
        padding-top: 30px;
        color: #1e704d;
        height: 100px;
        margin-left:360px;
    }
</style>