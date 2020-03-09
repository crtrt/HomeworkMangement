<%@ page import="com.java.code.class12.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.class12.jdbc.StudentHomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/8
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询作业</title>
</head>
<body>
    <!-- 引入header.jsp的头部文件 -->
    <%@ include file="header.jsp" %>

    <table style="margin-top: 30px;color:#1e704d;font-family: 宋体; "  align="center" width="800" border="0.8" bgcolor="#1e704d" cellpadding="1" cellspacing="1" >
        <tr align="center" bgcolor="#d5f1e5"  height="40">
            <td>ID</td>
            <td>学生学号</td>
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
        </tr>
        <%
            List<StudentHomework> list = StudentHomeworkJdbc.selectAll();
//         List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("list");

            if(null == list || list.size() <= 0){
                out.print("None data.");
            }else {
                for (StudentHomework sh : list){
        %>
        <tr align="center" bgcolor="white" height="30">
            <td><%=sh.getId()%></td>
            <td><%=sh.getStudentId()%></td>
            <td><%=sh.getHomeworkId()%></td>
            <td><%=sh.getHomeworkTitle()%></td>
            <td><%=sh.getHomeworkContent()%></td>
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
        background-image: url("../images/5.jpg");;
        background-size: 100%;
        background-repeat: no-repeat;
        font-family: 宋体;
    }
</style>