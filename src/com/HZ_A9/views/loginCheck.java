package com.HZ_A9.views;

import com.HZ_A9.entities.Admin;
import com.HZ_A9.entities.Student;
import com.HZ_A9.entities.Teacher;
import com.HZ_A9.mysql.jdbcUtils;
import com.HZ_A9.views.loginPage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginCheck {
    public boolean checkAdmin(Admin admin) throws SQLException {
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
            String password = resultSet.getString(2);
            int level = resultSet.getInt(3);
//            System.out.println(uNo + "\t"+ password + "\t"+
//                    level);
            if(admin.getUserNo().equals(uNo)&&admin.getUserPassword().equals(password)){
                System.out.println("密码正确！欢迎登录系统管理员端~");
                admin.setUserNo(uNo);
                admin.setLevel(level);
                admin.setUserPassword(password);
                return true;
            }
        }
        return false;
    }
    public boolean checkTeacher(Teacher teacher) throws SQLException {
        Connection connection = jdbcUtils.getConnection();
        System.out.println(connection);
        Statement statement = connection.createStatement();
        //4.执行语句
        String sql = "select * from tb_teacher";
        //executeQuery(String sql)执行给定的语句，返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);
        //5.使用while循环取到数据
        while(resultSet.next()){
            String uNo = resultSet.getString(2);
            String uname = resultSet.getString(3);
            String uSex = resultSet.getString(4);
            String uTel = resultSet.getString(5);
            String uOffice = resultSet.getString(6);
            String uBranch = resultSet.getString(7);
            String password = resultSet.getString(8);
//            System.out.println(uNo + "\t"+ password + "\t");
            if(teacher.gettNo().equals(uNo)&&teacher.gettPassword().equals(password)){
                teacher.settName(uname);
                teacher.settSex(uSex);
                teacher.settTel(uTel);
                teacher.settOffice(uOffice);
                teacher.settBranch(uBranch);
                System.out.println("密码正确！欢迎登录系统教师端~");
                return true;
            }
        }
        return false;
    }
    public boolean checkStudent(String username,String password) throws SQLException {
        Connection connection = jdbcUtils.getConnection();
//        System.out.println(connection);
        Statement statement = connection.createStatement();
        //4.执行语句
        String sql = "select * from tb_student";
        //executeQuery(String sql)执行给定的语句，返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);
        //5.使用while循环取到数据
        while(resultSet.next()){
            int s_id = resultSet.getInt(1);
            String s_no = resultSet.getString(2);
            String s_name = resultSet.getString(3);
            String s_sex = resultSet.getString(4);
            String s_date = resultSet.getString(5);
            String s_tel = resultSet.getString(6);
            String s_address = resultSet.getString(7);
            String s_password = resultSet.getString(8);
//            System.out.println(s_no + "\t"+ s_password + "\t");
            if(username.equals(s_no)&&password.equals(s_password)){
                loginPage.student.setsId(s_id);
                loginPage.student.setsNo(s_no);
                loginPage.student.setName(s_name);
                loginPage.student.setsSex(s_sex);
                loginPage.student.setsDate(s_date);
                loginPage.student.setsTel(s_tel);
                loginPage.student.setsAddress(s_address);
                loginPage.student.setsPassword(s_password);
                loginPage.student.toString();
                System.out.println("密码正确！欢迎登录系统学生端~");
                return true;
            }
        }
        return false;
    }
}
