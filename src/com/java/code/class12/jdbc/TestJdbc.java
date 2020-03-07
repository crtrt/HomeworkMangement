package com.java.code.class12.jdbc;

import java.sql.*;

public class TestJdbc {
    public static String getMysql()  {
        String url="jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";

        String sqlString = "select * from student limit 10";

        try {
            //创建连接
            Connection connection = DriverManager.getConnection(url,"root","123456");
            //通过连接获取statement
            Statement statement = connection.createStatement();
            //statement 增、删、改、查
            ResultSet resultSet = statement.executeQuery(sqlString);
            //获取执行结果
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static void main(String[] args){
        getMysql();
    }
}
