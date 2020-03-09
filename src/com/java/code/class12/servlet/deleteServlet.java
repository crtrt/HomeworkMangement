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

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        StudentHomework sh = new StudentHomework();

        //获取当前时间
        Timestamp now = new Timestamp(new Date().getTime());
        /**
         * 赋值
         */
//        sh.setStudentId(Long.parseLong(req.getParameter("id")));
        String[] selectdelete = req.getParameterValues("chk");
        PrintWriter out = resp.getWriter();
        if(selectdelete.length<=0||selectdelete==null){
            out.print("<script>alert('You should select one item at least!'); window.location='/StudentJSP/selectMy.jsp' </script>");
        }
        String ids ="";
        for(int i=0;i<selectdelete.length;i++){
            ids += "'"+selectdelete[i]+"'";
            if(i!=selectdelete.length-1) ids+=",";
        }

        StudentHomeworkJdbc.deleteHomework(ids);

        out.print("<script>alert('Delete successfully!'); window.location='/StudentJSP/subHomework.jsp' </script>");

    }
}
