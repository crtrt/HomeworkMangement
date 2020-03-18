<%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="nav" >
    <ul class="list">
        <li style="margin-left: 300px"><a   href="/TeacherJSP/readHomework.jsp">查看作业</a></li>
        <li><a href="/TeacherJSP/addHomework.jsp">添加作业</a></li>
        <li><a href="/TeacherJSP/addStudent.jsp">添加学生</a></li>
        <li><a href="../index.jsp">返回首页</a></li>
    </ul>
</div>
<style>
    #nav{
        margin: 0 auto;
        padding: 0 ;
        box-shadow: 0 0 10px 4px rgba(213,241,229,0.1);
        background-color: rgba(213,241,229,0.4);
        font-size: 20px;
    }

    .list a {
        text-decoration: none;
        color: #1e704d;
    }
    li {
        list-style: none;
        height: 60px;
        line-height: 60px;
    }
    #nav .list{
        display: flex;
    }
    #nav .list li {
        padding: 0 20px;
        cursor: pointer;
    }
    #nav .list li:hover {
        background-color: #1e704d;
        transition: all 2s ease;
    }
    #nav .list li:hover a {
        color: #fff;
    }


</style>