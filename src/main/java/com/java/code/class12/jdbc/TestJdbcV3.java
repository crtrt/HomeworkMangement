package com.java.code.class12.jdbc;

import java.sql.*;

public class TestJdbcV3 {
    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM student";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int n = 100;
        while (n-- >= 0){
            try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
                try(Statement statement = connection.createStatement()){
                    try(ResultSet resultSet = statement.executeQuery(sqlString)){
                        // 获取执行结果
                        while (resultSet.next()){
                            System.out.println(resultSet.getString(2));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        getMysql();
    }
}

