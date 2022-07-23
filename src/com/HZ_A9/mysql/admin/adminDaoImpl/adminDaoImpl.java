package com.HZ_A9.mysql.admin.adminDaoImpl;
import com.HZ_A9.mysql.admin.adminDao.adminDao;
//import com.shihao.JDBCUtils.jdbcUtils;
import com.HZ_A9.utils.*;
import java.sql.*;
import java.util.Scanner;

public class adminDaoImpl implements adminDao {
    String defaultPassword = "NJUPT";
    @Override
    public void showAllUser() {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        String sqlStu = "select * from tb_student";
        String sqlTea = "select * from tb_teacher";
        ResultSet set = null;
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sqlStu);
            set = preparedStatement.executeQuery();
            System.out.println("学生用户信息如下:");
            while(set.next()){
                int s_id = set.getInt("s_id");
                String s_no = set.getString("s_no");
                String s_name = set.getString("s_name");
                String s_sex = set.getString("s_sex");
                String s_date = set.getString("s_data");
                String s_tel = set.getString("s_tel");
                String s_address = set.getString("s_address");
                String s_password = set.getString("s_password");
                System.out.println(s_id + "\t" + s_no + "\t" +s_name + "\t" + s_sex
                        + "\t" + s_date + "\t" + s_tel + "\t" +s_address + "\t" +
                        s_password);
            }
            preparedStatement = connection.prepareStatement(sqlTea);
            set = preparedStatement.executeQuery();
            System.out.println("教师用户信息如下:");
            while(set.next()){
                int t_id = set.getInt("t_id");
                String t_no = set.getString("t_no");
                String t_name = set.getString("t_name");
                String t_sex = set.getString("t_sex");
                String t_tel = set.getString("t_tel");
                String t_office = set.getString("t_office");
                String t_branch = set.getString("t_branch");
                String t_password = set.getString("t_password");
                System.out.println(t_id + "\t" + t_no + "\t" +t_name + "\t" + t_sex
                        + "\t" + t_tel + "\t" + t_office + "\t" +t_branch + "\t" +
                        t_password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }

    @Override
    public boolean resetUser() {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        System.out.println("请输入你要需要重置的账号:");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        ResultSet set = null;
        if(username.contains("teacher")){
            System.out.println("您输入的是教师账号，即将开始重置......");
            String sqlTea = "update tb_teacher set t_password = '" + defaultPassword + "'where t_no = ?";
            try {
                connection = jdbcUtils.getConnection();
                preparedStatement = connection.prepareStatement(sqlTea);
                preparedStatement.setString(1,username);
                int rows = preparedStatement.executeUpdate();
                if(rows == 1){
                    System.out.println("教师密码修改成功~");
                    return true;
                }else{
                    System.out.println("教师密码重置失败！");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                jdbcUtils.close(set,preparedStatement,connection);

            }
        }else{
            System.out.println("您输入的是学生账号，即将开始重置......");
            String sqlStu = "update tb_student set s_password = '" + defaultPassword + "'where s_no = ?";
            try {
                connection = jdbcUtils.getConnection();
                preparedStatement = connection.prepareStatement(sqlStu);
                preparedStatement.setString(1,username);
                int rows = preparedStatement.executeUpdate();
                if(rows == 1){
                    System.out.println("学生密码修改成功~");
                    return true;
                }else{
                    System.out.println("学生密码重置失败！");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                jdbcUtils.close(set,preparedStatement,connection);
            }
        }
    }

    @Override
    public boolean addUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        System.out.println("输入您要增加的账号");
        System.out.println("格式账号格式为(学生:student_xx||教师:teacher_xx)");
        Scanner sc = new Scanner(System.in);
        Scanner tp = new Scanner(System.in);
        String userName = sc.next();
        String temp = sc.nextLine();
        checkFormat checkFormat = new checkFormat();
        isUserExist isUserExist = new isUserExist();
        while(true){
            if(checkFormat.checkTeacher(userName)&&!isUserExist.isExistTeacher(userName)){
                System.out.println("新增教师用户名格式正确,请继续录入信息:");
                System.out.println("新增教师姓名:");
                String t_name = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的教师性别:");
                String t_sex = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的教师电话:");
                String t_tel = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的教师办公室");
                String t_office = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的教师院系");
                String t_branch = sc.next();
                temp = sc.nextLine();
                System.out.println("正在生成新的账号......");
                String newTea = "insert into tb_teacher values (null,?,?,?,?,?,?,'"+defaultPassword+"')";
                try {
                    connection = jdbcUtils.getConnection();
                    preparedStatement = connection.prepareStatement(newTea);
                    preparedStatement.setString(1,userName);
                    preparedStatement.setString(2,t_name);
                    preparedStatement.setString(3,t_sex);
                    preparedStatement.setString(4,t_tel);
                    preparedStatement.setString(5,t_office);
                    preparedStatement.setString(6,t_branch);
                    int rows = preparedStatement.executeUpdate();
                    if(rows>0){
                        System.out.println("教师新增成功~");
                        return true;
                    }else{
                        System.out.println("教师新增失败！");
                        return false;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    jdbcUtils.close(set,preparedStatement,connection);
                }
            } else if (checkFormat.checkStudent(userName)&&!isUserExist.isExistStudent(userName)) {
                System.out.println("新增学生用户名格式正确,请继续录入信息:");
                System.out.println("新增学生姓名:");
                String s_name = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的学生性别:");
                String s_sex = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的学生入校日期:");
                String s_date = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的学生电话:");
                String s_tel = sc.next();
                temp = sc.nextLine();
                System.out.println("您要增加的学生籍贯");
                String s_address = sc.next();
                temp = sc.nextLine();
                System.out.println("正在生成新的账号......");
                String newStu = "insert into tb_student values (null,?,?,?,?,?,?,'"+defaultPassword+"')";
                try {
                    connection = jdbcUtils.getConnection();
                    preparedStatement = connection.prepareStatement(newStu);
                    preparedStatement.setString(1,userName);
                    preparedStatement.setString(2,s_name);
                    preparedStatement.setString(3,s_sex);
                    preparedStatement.setString(4,s_date);
                    preparedStatement.setString(5,s_tel);
                    preparedStatement.setString(6,s_address);
                    int rows = preparedStatement.executeUpdate();
                    if(rows>0){
                        System.out.println("学生新增成功~");
                        return true;
                    }else{
                        System.out.println("学生新增失败！");
                        return false;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    jdbcUtils.close(set,preparedStatement,connection);
                }
            }else{
                System.out.println("输入的新用户名格式不正确或已存在，请重新输入:");
                userName = sc.next();
                temp = sc.nextLine();
            }
        }
    }

    @Override
    public boolean deleteUser() {
        isUserExist isUserExist = new isUserExist();
        System.out.println("输入您要删除的账号:");
        Scanner sc = new Scanner(System.in);
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        String username = sc.next();
        String temp = sc.nextLine();
        ResultSet set = null;
        while(true){
            boolean flag = (isUserExist.isExistTeacher(username)||isUserExist.isExistStudent(username))?true:false;
            if(!flag){
                System.out.println("输入的账号不存在，请重新输入:");
                username = sc.next();
                temp = sc.nextLine();
            }else{
                break;
            }
        }
        if(username.contains("teacher")) {
            System.out.println("您输入的是教师账号，即将开始删除......");
            String deleteTea = "delete from tb_teacher where t_no = ?";
            try {
                connection = jdbcUtils.getConnection();
                preparedStatement = connection.prepareStatement(deleteTea);
                preparedStatement.setString(1, username);
                int rows = preparedStatement.executeUpdate();
                if (rows == 1) {
                    System.out.println("该教师账号删除成功~");
                    return true;
                } else {
                    System.out.println("该教师密码删除失败！");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                jdbcUtils.close(set, preparedStatement, connection);

            }
        }else{
                System.out.println("您输入的是学生账号，即将开始删除......");
                String deleteStu = "delete from tb_student where s_no = ?";
                try {
                    connection = jdbcUtils.getConnection();
                    preparedStatement = connection.prepareStatement(deleteStu);
                    preparedStatement.setString(1,username);
                    int rows = preparedStatement.executeUpdate();
                    if(rows == 1){
                        System.out.println("该学生账号删除成功~");
                        return true;
                    }else{
                        System.out.println("该学生账号删除失败！");
                        return false;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    jdbcUtils.close(set,preparedStatement,connection);

                }
            }
    }
}
