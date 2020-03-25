<%--
  Created by IntelliJ IDEA.
  User: enovo
  Date: 2020/3/11
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>

<%
    String id=request.getParameter("id");
    String stuId=request.getParameter("stuId");
    String hmwTitle=request.getParameter("hmwTitle");
    String hmwId=request.getParameter("hmwId");
    String hmwContent=request.getParameter("hmwContent");

%>
<div class="frame" >
    <form action="../updateServlet" method="post" >
        <p><label style="margin-top: 20px" class="label_input">*编号</label><input style="margin-top: 20px" type="text"readOnly="true" name="id" class="text_field1" value=<%=id%>></p>
        <p><label class="label_input">*学生学号</label><input type="text" readOnly="true" name="stuId" class="text_field1" value=<%=stuId%>></p>
        <p><label class="label_input">*作业编号</label><input type="text"readOnly="true" name="hmwId" class="text_field1" value=<%=hmwId%>></p>
        <p><label class="label_input">作业标题</label><input type="text" name="title" class="text_field" value=<%=hmwTitle%>></p>
        <p><label class="label_input">作业内容</label><input type="text" name="content" class="text_field " value=<%=hmwContent%>></p>
        <div id="control">
            <input style="margin-top: 20px" type="submit" id="btn" value="确认" />
        </div>
    </form>

</div>
</body>
</html>
<style>
    body {
        background-image: url("../images/2.jpg");;
        background-size: 100%;
        background-repeat: no-repeat;
        font-family: 宋体;
    }

    .frame {
        width: 800px;
        height: 400px;
        position: absolute;
        padding-top: 13px;
        left: 50%;
        top: 40%;
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
    .text_field1 {
        background-color: #d5f1e5;
        width: 278px;
        height: 32px;
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
        border: 0;
    }
</style>