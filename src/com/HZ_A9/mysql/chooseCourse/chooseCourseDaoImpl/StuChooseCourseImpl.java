package com.HZ_A9.mysql.chooseCourse.chooseCourseDaoImpl;

import com.HZ_A9.entities.Student;
import com.HZ_A9.mysql.chooseCourse.chooseCourseDao.chooseCourse;
import com.HZ_A9.views.loginPage;
//import com.shihao.JDBCUtils.jdbcUtils;
import com.HZ_A9.utils.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StuChooseCourseImpl implements chooseCourse {
    Connection connection = null;
    PreparedStatement preparedStatement1 = null;
    PreparedStatement preparedStatement2 = null;
    PreparedStatement preparedStatement3 = null;
    PreparedStatement preparedStatement4 = null;
    ResultSet set1 = null;
    ResultSet set2 = null;
    String teaNo = null;
    String stuNo = null;
    String couNo = null;

    @Override
    @Test
    public boolean StuChooseCourse(Student student) {
        System.out.println("目前的选课信息：");
        String sql1 = "select * from tb_course";
        String sql2 = "select * from tb_course where c_id = ?";
        String sql3 = "update tb_course set c_allowance = ? where c_id = ?";
        String sql4 = "insert into tb_choose_course values(null,?,?,?)";
        try {
            connection = jdbcUtils.getConnection();
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement3 = connection.prepareStatement(sql3);
            preparedStatement4 = connection.prepareStatement(sql4);
            set1 = preparedStatement1.executeQuery();

            System.out.println("选课ID\t\t\t" + "课程号\t\t\t" + "课程名\t\t\t" + "所属学院\t\t\t" +
                    "上课教室\t\t\t" + "课时\t\t\t" + "选课余量\t\t\t" + "授课老师\t\t\t");
            while(true){
                while(set1.next()){
                    int c_id = set1.getInt("c_id");
                    String c_no = set1.getString("c_no");
                    String c_name = set1.getString("c_name");
                    String c_branch = set1.getString("c_branch");
                    String c_address = set1.getString("c_address");
                    String c_amount = set1.getString("c_amount");
                    String c_allowance = set1.getString("c_allowance");
                    String t_no = set1.getString("t_no");
                    System.out.println(c_id + "\t\t\t" +c_no + "\t\t\t" + c_name +"\t\t\t"
                            + c_branch + "\t\t\t" + c_address + "\t\t\t" + c_amount + "\t\t\t"
                            + c_allowance + "\t\t\t" + t_no);
                }
                System.out.println("请输入你要选修的课程id(数字):");
                Scanner sc = new Scanner(System.in);
                int c_id = sc.nextInt();
                preparedStatement2.setInt(1,c_id);
                set2 = preparedStatement2.executeQuery();
                int allowance = 0;
                while(set2.next()){
                    couNo = set2.getString("c_no");
                    teaNo = set2.getString("t_no");
                    allowance = set2.getInt("c_allowance");
                }
                if(allowance == 0){
                    System.out.println("此课余量已不足，请选择其他课程！");
                }else{
                    allowance = allowance - 1;
                    preparedStatement3.setInt(1,allowance);
                    preparedStatement3.setInt(2,c_id);
                    int rows = preparedStatement3.executeUpdate();
                    System.out.println(rows>0?"选课成功,且成功修改数据库":"选课成功，但修改数据库失败");
                    stuNo = loginPage.student.getsNo();

                    preparedStatement4.setString(1,couNo);
                    preparedStatement4.setString(2,teaNo);
                    preparedStatement4.setString(3,stuNo);
                    rows = preparedStatement4.executeUpdate();
                    System.out.println(rows>0?"学生选课表修改成功":"学生选课表修改失败");
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.close(set1,preparedStatement1,connection);
            jdbcUtils.close(set2,preparedStatement2,connection);
        }
        return false;
    }
}
