package com.HZ_A9.utils;
import com.HZ_A9.views.loginPage;
import java.util.Scanner;

public class checkSourcePwd {
    public boolean checkSourceTeacherPwd(){
        Scanner sc = new Scanner(System.in);
        String temp = null;
        while(true){
            System.out.println("请输入原密码进行验证:");
            String sourcePwd = sc.next();
            temp = sc.nextLine();
            if(!sourcePwd.equals(loginPage.teacher.gettPassword())){
                System.out.println("原密码校验错误，请重新输入:");
                sourcePwd = sc.next();
                temp = sc.nextLine();
            }else{
                return true;
            }
        }
    }
    public boolean checkSourceStucherPwd(){
        Scanner sc = new Scanner(System.in);
        String temp = null;
        System.out.println("请输入原密码进行验证:");
        String sourcePwd = sc.next();
        temp = sc.nextLine();
        while(true){
            if(!sourcePwd.equals(loginPage.student.getsPassword())){
                System.out.println("原密码校验错误，请重新输入:");
                sourcePwd = sc.next();
                temp = sc.nextLine();
            }else{
                System.out.println("密码校验正确！");
                return true;
            }
        }
    }
}
