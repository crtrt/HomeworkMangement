<%@ page import="com.java.code.class12.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.class12.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.java.code.class12.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div id="frame">
        <form action="../AddStudentServlet" method="post" >
            <p><label style="margin-top: 8px" class="label_input">学生学号</label><input style="margin-top: 8px" type="text" name="id" class="text_field"/></p>
            <p><label class="label_input">学生姓名</label><input type="text" name="name" class="text_field"/></p>
            <div id="control">
                <input type="submit" id="btn" value="确认添加" />
            </div>
        </form>
    </div>

    <table style="margin-top: 250px;color:#1e704d " align="center" width="800" border="0.8" bgcolor="#1e704d" cellpadding="1" cellspacing="1" >
        <tr align="center" bgcolor="#d5f1e5" height="40">
            <td>学生学号</td>
            <td>学生姓名</td>
            <td>创建时间</td>
        </tr>
        <%
            List<Student> list = StudentHomeworkJdbc.selectStudent();

            if(null == list || list.size() <= 0){
                out.print("None data.");
            }else {
                for (Student sh : list){
        %>
        <tr align="center" bgcolor="white" height="30">
            <td><%=sh.getId()%></td>
            <td><%=sh.getName()%></td>
            <td><%=sh.getCreateTime()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>



</body>
</html>
<style>
    body {
        background-image: url("../images/4.jpg");;
        background-size: 100%;
        background-repeat: no-repeat;
        font-family: 宋体;
    }

    #frame {
        width: 800px;
        height: 150px;
        position: absolute;
        padding-top: 13px;
        left: 50%;
        top: 35%;
        margin-left: -400px;
        margin-top: -100px;
        background-color: rgba(240, 255, 255, 0.5);
        border-radius: 10px;
        text-align: center;
    }

    #btn{
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
        margin: auto 0;
    }

    form p > * {
        display: inline-block;
        vertical-align: middle;
    }

    .label_input {
        font-size: 16px;
        font-family: 宋体;
        width: 80px;
        height: 32px;
        line-height: 28px;
        text-align: center;
        color: #1e704d;
        background-color: #d5f1e5;
        border-top-left-radius: 5px;
        border-bottom-left-radius: 5px;
    }


    .text_field {
        width: 278px;
        height: 32px;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
        border: 0;
    }

</style>