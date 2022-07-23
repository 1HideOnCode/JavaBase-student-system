package com.HZ_A9.views;
import com.HZ_A9.utils.checkChoice;
import com.HZ_A9.entities.Admin;
import com.HZ_A9.entities.Student;
import com.HZ_A9.entities.Teacher;

import java.sql.SQLException;
import java.util.Scanner;

public class loginPage {
    public static Admin admin = new Admin();
    public static Teacher teacher = new Teacher();
    public static Student student = new Student();
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to XX-System!");
        System.out.println("=========1.管理员登录=======");
        System.out.println("=========2.教师登录=======");
        System.out.println("=========3.学生登录=======");
        System.out.println("=========4.退出=======");
        Scanner sc = new Scanner(System.in);
        String choice = null;
        String temp = null;
        String name = null;
        String pwd = null;
        System.out.println("请输入您的选择:");
        choice = sc.next();
        temp = sc.nextLine();
        loginCheck lk = new loginCheck();
        checkChoice checkChoice = new checkChoice();
        while(true){
            boolean flagChoice = checkChoice.checkLoginChoice(choice);
            if(!flagChoice){
                System.out.println("选择错误，请重新输入:");
                choice = sc.next();
                temp = sc.nextLine();
            }else{
                switch(choice){
                    case "1":
                        System.out.println("请输入您的管理员账号:");
                        name = sc.next();
                        temp = sc.nextLine();
                        System.out.println("请输入您的管理员密码:");
                        pwd = sc.next();
                        admin = new Admin(name,pwd,1);
                        boolean flag = lk.checkAdmin(admin);
                        if(flag){
                            adminPage.main(args);
                        }else{
                            System.out.println("账号或密码错误，请重新输入:");
                        }
                        break;
                    case "2":
                        System.out.println("请输入您的教师账号:");
                        name = sc.next();
                        temp = sc.nextLine();
                        System.out.println("请输入您的教师密码:");
                        pwd = sc.next();
                        teacher.settNo(name);
                        teacher.settPassword(pwd);
                        flag = lk.checkTeacher(teacher);
                        if(flag){
                            teacherpage.main(args);
                        }else{
                            System.out.println("账号或密码错误，请重新输入:");
                        }
                        break;
                    case "3":
                        System.out.println("请输入您的学生账号:");
                        name = sc.next();
                        temp = sc.nextLine();
                        System.out.println("请输入您的学生密码:");
                        pwd = sc.next();
                        flag = lk.checkStudent(name,pwd);
                        if(flag){
                            studentPage.main(args);
                        }else{
                            System.out.println("账号或密码错误，请重新输入:");
                        }
                        break;
                    case "4":
                        System.exit (1);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }

            }
        }
    }
}
