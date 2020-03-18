package com.java.code.class12.jdbc;

import com.java.code.class12.model.Homework;
import com.java.code.class12.model.Student;
import com.java.code.class12.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {



    public static void connectUpdate(String sql){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            // 加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                //插入
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    查看所有提交的作业
     */
    public static List<StudentHomework> selectAll(){

        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student_homework";
        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        sh.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    /*
    添加作业Homework
     */
    public static String addStudentHomework(Homework hw){

        String sqlString = "INSERT INTO s_homework(id,title,content,create_time) VALUES (null,'" + hw.getTitle() + "','" + hw.getContent() + "','" + hw.getCreateTime()+ "')";
        connectUpdate(sqlString);
        return "添加成功";
    }
    /*
       添加学生Student
   */
    public static String addStudent(Student sh){

        String sqlString = "INSERT INTO s_student(id,name,create_time) VALUES ('" + sh.getId() + "','" + sh.getName() + "','" + sh.getCreateTime()+ "')";
        connectUpdate(sqlString);
        return "添加成功";
    }
    /*
     提交作业StudentHomework
    */
    public static String submitHomework(StudentHomework sh) {

        String sqlString = "INSERT INTO s_student_homework(id,student_id,homework_id,homework_title,homework_content,create_time) VALUES" +
                "(null,'" + sh.getStudentId() + "','" + sh.getHomeworkId() + "','"
                + sh.getHomeworkTitle() + "','" + sh.getHomeworkContent() + "','" + sh.getCreateTime() + "')";
        connectUpdate(sqlString);
        return "提交成功";
    }
    /*
      查看老师布置的的作业Homework
       */
    public static List<Homework> selectHomework(){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_homework";

        List<Homework> list = new ArrayList<>();

        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Homework hw = new Homework();
                        hw.setId(resultSet.getLong("id"));
                        hw.setTitle(resultSet.getString("title"));
                        hw.setContent(resultSet.getString("content"));
                        hw.setCreateTime(resultSet.getTimestamp("create_time"));
                        hw.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(hw);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /*
    查看学生列表student
     */
    public static List<Student> selectStudent() {
        String sqlString = "SELECT * FROM s_student";

        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        List<Student> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        Student sh = new Student();
                        sh.setId(resultSet.getLong("id"));
                        sh.setName(resultSet.getString("name"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
      查看自已提交的作业
       */
    public static List<StudentHomework> selectMy(Long stuId){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student_homework where student_id='" + stuId+ "'";
        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        sh.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /*
    删除自己的作业Homework
     */

    public static String deleteHomework(String ids) {
        String sqlString = "delete from s_student_homework where id in ("+ids+")";
        connectUpdate(sqlString);
        return "删除成功";
    }
    /*
    修改自己已提交的作业
     */
    public static String updateHomework(StudentHomework sh) {
        String sqlString = "update s_student_homework set homework_title='"+sh.getHomeworkTitle()+"',homework_content='"+sh.getHomeworkContent()+"',update_time='"+sh.getUpdateTime()+"'where id='"+sh.getId()+ "'";
        connectUpdate(sqlString);
        return "修改成功";
    }
}
