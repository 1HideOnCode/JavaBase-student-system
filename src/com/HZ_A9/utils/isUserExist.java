package com.HZ_A9.utils;
import com.HZ_A9.utils.*;
//import com.shihao.JDBCUtils.jdbcUtils;

import java.sql.*;

public class isUserExist {
    public boolean isExistStudent(String username){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        boolean flag = false;
        try {
            String sql = "select * from tb_student where s_no = ?";
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            set = preparedStatement.executeQuery();
            while (set.next()){
                String u_no = set.getString("s_no");
                flag = true;
                System.out.println("该学生账号已存在，请重新填写账号");
                return flag;
            }
            return flag;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }
    public boolean isExistTeacher(String username){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        boolean flag = false;
        try {
            String sql = "select * from tb_teacher where t_no = ?";
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            set = preparedStatement.executeQuery();
            while (set.next()){
                String u_no = set.getString("t_no");
                flag = true;
                System.out.println("该教师账号已存在，请重新填写账号");
                return flag;
            }
            return flag;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }
}
