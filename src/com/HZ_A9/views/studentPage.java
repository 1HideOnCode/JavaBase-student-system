package com.HZ_A9.views;
import com.HZ_A9.mysql.chooseCourse.chooseCourseDaoImpl.StuChooseCourseImpl;
import com.HZ_A9.mysql.student.studentDaoImpl.studentDaoImpl;
import java.util.Scanner;
import com.HZ_A9.views.loginPage;

public class studentPage {
    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("==========1.查看用户信息=========");
        System.out.println("==========2.下载选课课程=========");
        System.out.println("==========3.选课============");
        System.out.println("==========4.修改密码=============");
        System.out.println("==========5.退出系统============");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("请输入您的选择:");
        choice = sc.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    new studentDaoImpl().showStudentInfo(loginPage.student);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.下载选课课程=========");
                    System.out.println("==========3.选课============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 2:
                    new studentDaoImpl().downloadChooseCourseInfo(loginPage.student);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.下载选课课程=========");
                    System.out.println("==========3.选课============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 3:
                    new StuChooseCourseImpl().StuChooseCourse(loginPage.student);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.下载选课课程=========");
                    System.out.println("==========3.选课============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 4:
                    new studentDaoImpl().updateStudentPassword(loginPage.student);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.下载选课课程=========");
                    System.out.println("==========3.选课============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 5:
                    System.out.println("感谢使用，再见是为了更好的重逢~");
                    System.exit(1);
                    break;
            }

        }
    }
}
