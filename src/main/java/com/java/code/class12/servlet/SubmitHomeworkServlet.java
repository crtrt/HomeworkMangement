package com.java.code.class12.servlet;

import com.java.code.class12.jdbc.StudentHomeworkJdbc;
import com.java.code.class12.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet("/SubmitHomeworkServlet")
public class SubmitHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentHomework sh = new StudentHomework();
        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
        sh.setStudentId(Long.parseLong(req.getParameter("student_id")));
        sh.setHomeworkId(Long.parseLong(req.getParameter("homework_id")));
        sh.setHomeworkTitle(req.getParameter("homework_title"));
        sh.setHomeworkContent(req.getParameter("homework_content"));
        sh.setCreateTime(now);
        StudentHomeworkJdbc.submitHomework(sh);
        PrintWriter out = resp.getWriter();
        out.print("<script>alert('Submit successfully!'); window.location='/StudentJSP/subHomework.jsp' </script>");

    }
}
