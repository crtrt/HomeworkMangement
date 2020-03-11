package com.java.code.class12.jdbc;

import com.java.code.class12.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    public static void main(String[] args) {
        List<StudentHomework> list = selectAll();

        for (StudentHomework sh : list){
            System.out.println(sh.getHomeworkContent());
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
    添加作业
     */
    public static String addStudentHomework(StudentHomework sh){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String sqlString = "INSERT INTO s_homework(id,title,content,create_time) VALUES (null,'" + sh.getHomeworkTitle() + "','" + sh.getHomeworkContent() + "','" + sh.getCreateTime()+ "')";
        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                //插入
                statement.executeUpdate(sqlString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "添加成功";
    }
    /*
       添加学生
   */
    public static String addStudent(StudentHomework sh){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String sqlString = "INSERT INTO s_student(id,name,create_time) VALUES ('" + sh.getStudentId() + "','" + sh.getStuName() + "','" + sh.getCreateTime()+ "')";
        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(Statement statement = connection.createStatement()){
                //插入
                statement.executeUpdate(sqlString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "添加成功";
    }
    /*
     提交作业
    */
    public static String submitHomework(StudentHomework sh) {
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String sqlString = "INSERT INTO s_student_homework(id,student_id,homework_id,homework_title,homework_content,create_time) VALUES" +
                "(null,'" + sh.getStudentId() + "','" + sh.getHomeworkId() + "','"
                + sh.getHomeworkTitle() + "','" + sh.getHomeworkContent() + "','" + sh.getCreateTime() + "')";
        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                //插入
                statement.executeUpdate(sqlString);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "提交成功";
    }
    /*
      查看老师布置的的作业
       */
    public static List<StudentHomework> selectHomework(){

        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_homework";
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
                        sh.setHomeworkId(resultSet.getLong("id"));
                        sh.setHomeworkTitle(resultSet.getString("title"));
                        sh.setHomeworkContent(resultSet.getString("content"));
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
    查看学生列表
     */
    public static List<StudentHomework> selectStudent(){

        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student";
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
                        sh.setStuName(resultSet.getString("name"));
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
    删除自己的作业
     */


    public static String deleteHomework(String ids) {
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String sqlString = "delete from s_student_homework where id in ("+ids+")";
        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                //插入
                statement.executeUpdate(sqlString);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "删除成功";
    }
    /*
    修改自己已提交的作业
     */
    public static String updateHomework(StudentHomework sh) {
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String sqlString = "update s_student_homework set homework_title='"+sh.getHomeworkTitle()+"',homework_content='"+sh.getHomeworkContent()+"',update_time='"+sh.getUpdateTime()+"'where id='"+sh.getId()+ "'";
        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "123456")) {
            try (Statement statement = connection.createStatement()) {
                //插入
                statement.executeUpdate(sqlString);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "修改成功";
    }
}
