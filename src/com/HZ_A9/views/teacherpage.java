package com.HZ_A9.views;
import com.HZ_A9.views.loginPage;
import java.util.Scanner;
import com.HZ_A9.mysql.teacher.teacherDaoImpl.teacherDaoImpl;
public class teacherpage {
    public static void main(String[] args) {
        System.out.println("============欢迎教师============");
        System.out.println("==========1.查看用户信息=========");
        System.out.println("==========2.查看课程信息=========");
        System.out.println("==========3.新增课程============");
        System.out.println("==========4.修改密码=============");
        System.out.println("==========5.退出系统============");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("请输入您的选择:");
        choice = sc.nextInt();
        while(true){
            switch(choice){
                case 1:
                    new teacherDaoImpl().showTeacherInfo(loginPage.teacher);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.查看课程信息=========");
                    System.out.println("==========3.新增课程============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 2:
                    new teacherDaoImpl().showCourseInfo(loginPage.teacher);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.查看课程信息=========");
                    System.out.println("==========3.新增课程============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 3:
                    new teacherDaoImpl().addCourse(loginPage.teacher);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.查看课程信息=========");
                    System.out.println("==========3.新增课程============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 4:
                    new teacherDaoImpl().updateTeacherPassword(loginPage.teacher);
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("=========================");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.查看课程信息=========");
                    System.out.println("==========3.新增课程============");
                    System.out.println("==========4.修改密码=============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 5:
                    System.out.println("感谢使用，再见是为了更好的重逢~");
                    System.exit (1);
                    break;
            }

        }
    }
}
