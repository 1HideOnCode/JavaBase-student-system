package com.HZ_A9.mysql.teacher.teacherDaoImpl;
import com.HZ_A9.utils.checkSourcePwd;
import com.HZ_A9.entities.Teacher;
import com.HZ_A9.mysql.teacher.teacherDao.teacherDao;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
//import com.shihao.JDBCUtils.jdbcUtils;
import com.HZ_A9.utils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.HZ_A9.utils.isCourseExist;
import com.HZ_A9.views.loginPage;

public class teacherDaoImpl implements teacherDao {


    @Override
    public void showTeacherInfo(Teacher teacher) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        String sql = "select * from tb_teacher where t_no = ?";
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,teacher.gettNo());
            set = preparedStatement.executeQuery();
            while(set.next()){
                int t_id = set.getInt("t_id");
                String t_no = set.getString("t_no");
                String t_name = set.getString("t_name");
                String t_sex = set.getString("t_sex");
                String t_tel = set.getString("t_tel");
                String t_office = set.getString("t_office");
                String t_branch = set.getString("t_branch");
                String t_password = set.getString("t_password");
                System.out.println("教师信息为:\n"+"教师ID:"+t_id + "\t教师用户名:" +t_no + "\t教师姓名:" + t_name +"\t性别:"
                + t_sex + "\t电话:" + t_tel + "\t办公地址:" + t_office + "\t隶属学院:" + t_branch+"\t"+"密码:"
                         + t_password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }

    @Override
    public void showCourseInfo(Teacher teacher) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        String sql = "select * from tb_course where t_no = ?";
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,teacher.gettNo());
            set = preparedStatement.executeQuery();
            int allowance = 0;
            System.out.println("您的课程信息如下");
            System.out.println("课程号\t\t\t课程名\t\t上课教室\t\t余量");
            while(set.next()){
                String c_name = set.getString("c_name");
                String c_no = set.getString("c_no");
                allowance = set.getInt("c_allowance");
                String c_address = set.getString("c_address");
                System.out.println(c_no + "\t" + c_name +"\t" + c_address + "\t\t" + allowance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }

    @Override
    public boolean addCourse(Teacher teacher) {
        isCourseExist isCourseExist = new isCourseExist();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        String c_no = null;
        String c_name = null;
        String c_address = null;
        String temp = null;
        int c_amount = 0;
        int c_allowance = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入新课程的编号:");
        c_no = sc.next();
        temp = sc.nextLine();
        boolean flag = true;
        while(true){
            flag = isCourseExist.isCourseExist(c_no);
            if(flag){
                System.out.println("该课程已存在，请重新输入");
                c_no = sc.next();
                temp = sc.nextLine();
                continue;
            }
            break;
        }
        System.out.println("请您输入新课程的名称:");
        c_name = sc.nextLine();
        System.out.println("请您输入新课程的上课地址:");
        c_address = sc.nextLine();
        System.out.println("请您输入新课程的总课时:");
        c_amount = sc.nextInt();
        System.out.println("请您输入新课程的选课余量:");
        c_allowance = sc.nextInt();
        String sqlAddCourse = "insert into tb_course values (null,?,?,?,?,?,?,?)";
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sqlAddCourse);
            preparedStatement.setString(1,c_no);
            preparedStatement.setString(2,c_name);
            preparedStatement.setString(3,teacher.gettBranch());
            preparedStatement.setString(4,c_address);
            preparedStatement.setInt(5,c_amount);
            preparedStatement.setInt(6,c_allowance);
            preparedStatement.setString(7,teacher.gettNo());
            int rows = preparedStatement.executeUpdate();
            if(rows == 1){
                System.out.println("新增课程数据已经插入数据库");
                return true;
            }else{
                System.out.println("新增课程数据插入数据库失败");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }

    @Override
    public boolean updateTeacherPassword(Teacher teacher) {
        checkSourcePwd checkSourcePwd = new checkSourcePwd();
        boolean flag = checkSourcePwd.checkSourceTeacherPwd();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        Scanner sc = new Scanner(System.in);
        if(flag){
            System.out.println("请输入您的新密码:");
            String newPwd1 = sc.next();
            String temp = sc.nextLine();
            String teaPwdUpdate = "update tb_teacher set t_password = ? where t_no = ?";
            try {
                System.out.println("请确认您的新密码:");
                String newPwd2 = sc.nextLine();
                flag = newPwd1.equals(newPwd2) ? true : false;
                if(flag){
                    System.out.println("修改成功，但新密码还未插入数据库");
                    teacher.settPassword(newPwd1);
                }else{
                    System.out.println("修改失败，且新密码还未插入数据库");
                    return false;
                }
                connection = jdbcUtils.getConnection();
                preparedStatement = connection.prepareStatement(teaPwdUpdate);
                preparedStatement.setString(1,teacher.gettPassword());
                preparedStatement.setString(2,teacher.gettNo());
                int rows = preparedStatement.executeUpdate();
                if(rows == 1){
                    System.out.println("新密码已插入数据库");
                }else{
                    System.out.println("密码插入数据库失败");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                jdbcUtils.close(set,preparedStatement,connection);
            }
        }
        return false;
    }
}
