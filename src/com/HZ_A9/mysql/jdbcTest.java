package com.HZ_A9.mysql;

import java.sql.*;

public class jdbcTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = jdbcUtils.getConnection();
        System.out.println(connection);
        Statement statement = connection.createStatement();
        //4.执行语句
        String sql = "select * from tb_admin";
        //executeQuery(String sql)执行给定的语句，返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);
        //5.使用while循环取到数据
        while(resultSet.next()){
            String uNo = resultSet.getString(1);
            String password = resultSet.getString(3);
            int level = resultSet.getInt(3);
            System.out.println(uNo + "\t"+ password + "\t"+
                    level);
        }
    }
}
