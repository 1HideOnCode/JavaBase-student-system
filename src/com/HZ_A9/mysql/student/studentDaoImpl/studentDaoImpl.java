package com.HZ_A9.mysql.student.studentDaoImpl;

import com.HZ_A9.entities.Student;
import com.HZ_A9.mysql.student.studentDao.studentDao;
//import com.shihao.JDBCUtils.jdbcUtils;
import com.HZ_A9.utils.*;
import com.HZ_A9.views.loginPage;
import java.sql.*;
import java.util.Scanner;

public class studentDaoImpl implements studentDao {
    //文件导出路径
    String defaultPath = "D:/download/";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet set = null;
    //4.执行语句
    @Override
    public void showStudentInfo(Student student) {
        String sql = "select * from tb_student where s_no = ?";
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getsNo());
            set = preparedStatement.executeQuery();
            while(set.next()){
                int s_id = set.getInt("s_id");
                String s_no = set.getString("s_no");
                String s_name = set.getString("s_name");
                String s_sex = set.getString("s_sex");
                String s_date = set.getString("s_data");
                String s_tel = set.getString("s_tel");
                String s_address = set.getString("s_address");
                String s_password = set.getString("s_password");
                System.out.println("您的信息如下:\n学生ID:\t"+s_id + "\t用户名:" +s_no + "\t姓名:" + s_name +
                        "\t性别:" +s_sex+"\t注册日期:"+ s_date +"\t电话:"+
                        s_tel+ "\t籍贯:" + s_address + "\t密码:" + s_password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
    }

    @Override
    public boolean downloadChooseCourseInfo(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要导出的文件文件名(限txt文本格式)");
        System.out.println("如xx.txt:");
        String path = sc.nextLine();
        path = defaultPath + path;
        System.out.println(path);

        String sql = "select tb_choose_course.cc_id,tb_choose_course.c_no,tb_course.c_name,tb_course.c_address,tb_course.t_no,tb_teacher.t_name \n" +
                "from tb_choose_course,tb_course,tb_teacher \n" +
                "where tb_choose_course.c_no = tb_course.c_no and tb_choose_course.s_no = ? and tb_course.t_no = tb_teacher.t_no into outfile '"+path+"'";
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getsNo());
            set = preparedStatement.executeQuery();
            while(set.next()){
//                String name = set.getString("NAME");
                int cc_id = set.getInt("cc_id");
                String c_no = set.getString("c_no");
                String t_no = set.getString("t_no");
                String s_no = set.getString("s_no");
                System.out.println("该生选课选课信息为");
                System.out.println(cc_id + "\t" +c_no + "\t" + t_no + "\t" + s_no);
            }
            System.out.println("您的选课信息已导入"+path);
        } catch (SQLException e) {
            System.out.println("文件已保存");
        } finally {
            jdbcUtils.close(set,preparedStatement,connection);
        }
        return false;
    }

    @Override
    public boolean chooseCourse(Student student) {
        return true;
    }

    @Override
    public boolean updateStudentPassword(Student student) {
        String oldPwd = student.getsPassword();
        /*
        因为上一句已经经过MD5修改了，所以就算输入原密码也会被MD5修改掉，所以不存在
        新密码和与密码相同的情况
         */
        loginPage.student = student.updatePassword(loginPage.student);
        if(oldPwd.equals(student.getsPassword())){
            System.out.println("新密码与原密码相同");
            return false;
        }else{
            String sql = "update tb_student set s_password = ? where s_no = ?";
            try {
                connection = jdbcUtils.getConnection();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,student.getsPassword());
                preparedStatement.setString(2,student.getsNo());
                int rows = preparedStatement.executeUpdate();
                System.out.println(rows>0?"新密码已插入数据库":"新密码插入数据库失败");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                jdbcUtils.close(set,preparedStatement,connection);
            }
            return false;
        }
    }
}
