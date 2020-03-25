<%@ page import="com.java.code.class12.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.class12.jdbc.StudentHomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎</title>
  </head>
  <body>

  <div id="frame">
        <p style="font-size: 28px">作业管理系统</p>
        <input type="button" id="t_btn_login" value="教师" onclick = "window.location.href = 'TeacherJSP/readHomework.jsp'"/>
        <input type="button" id="s_btn_login" value="学生" onclick = "window.location.href = 'StudentJSP/subHomework.jsp'"/>
  </div>

  </body>
</html>


<style>
  body {
    background-image: url("images/6.jpg");;
    background-size: 100%;
    background-repeat: no-repeat;
      color: #1e704d;
  }

  #frame {
    width: 400px;
    height: 260px;
    padding: 13px;
    position: absolute;
    left: 50%;
    top: 60%;
    margin-left: -200px;
    margin-top: -200px;
    background-color: rgba(240, 255, 255, 0.6);
    text-align: center;
  }

  #t_btn_login {
    margin-top: 60px;
    font-size: 16px;
    font-family: 宋体;
    width: 120px;
    height: 32px;
    line-height: 32px;
    text-align: center;
      color: #1e704d;
      background-color: #d5f1e5;
    border-radius: 6px;
    border: 0;
    float: left;
     margin-left: 30px;

  }

  #s_btn_login{
    margin-top: 60px;
    font-size: 16px;
    font-family: 宋体;
    width: 120px;
    height: 32px;
    line-height: 32px;
    text-align: center;
      color: #1e704d;
      background-color: #d5f1e5;
    border-radius: 6px;
    border: 0;
    float: right;
    margin-right: 30px;

  }

</style>