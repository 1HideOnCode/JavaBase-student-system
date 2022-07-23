package com.HZ_A9.utils;
//import com.shihao.JDBCUtils.jdbcUtils;
import com.HZ_A9.utils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class isCourseExist {
    public boolean isCourseExist(String courseNo){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        boolean flag = false;
        try {
            String sql = "select * from tb_course where c_no = ?";
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,courseNo);
            set = preparedStatement.executeQuery();
            while (set.next()){
                String u_no = set.getString("t_no");
                flag = true;
                System.out.println("该课程账号已存在，请重新填写账号");
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
