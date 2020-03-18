package com.java.code.class12.jdbc;

import java.sql.*;

public class TestJdbcV2 {
    public static String getMysql()  {
        String url="jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM student";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int n = 100;
        while(n-- >= 0) {
            try {
                // 加载驱动
                Class.forName(driverName);
                // 创建连接
                connection = DriverManager.getConnection(url,"root","123456");
                // 通过连接获取statement
                statement = connection.createStatement();
                // statement增删改查
                resultSet = statement.executeQuery(sqlString);
                // 获取执行结果
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                if (null != resultSet) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return null;
    }

    public static void main(String[] args) {
        getMysql();
    }

}