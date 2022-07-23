package com.HZ_A9.views;

import java.util.Scanner;
import com.HZ_A9.mysql.admin.adminDaoImpl.adminDaoImpl;
public class adminPage {
    public static void main(String[] args) {
        System.out.println("===========欢迎管理员===========");
        System.out.println("==========1.查看用户信息=========");
        System.out.println("==========2.重置用户信息=========");
        System.out.println("==========3.增加用户============");
        System.out.println("==========4.删除用户============");
        System.out.println("==========5.退出系统============");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("请输入您的选择:");
        choice = sc.nextInt();
        while(true){
            switch(choice){
                case 1:
                    new adminDaoImpl().showAllUser();
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.重置用户信息=========");
                    System.out.println("==========3.增加用户============");
                    System.out.println("==========4.删除用户============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 2:
                    new adminDaoImpl().resetUser();
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.重置用户信息=========");
                    System.out.println("==========3.增加用户============");
                    System.out.println("==========4.删除用户============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 3:
                    new adminDaoImpl().addUser();
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.重置用户信息=========");
                    System.out.println("==========3.增加用户============");
                    System.out.println("==========4.删除用户============");
                    System.out.println("==========5.退出系统============");
                    choice = sc.nextInt();
                    break;
                case 4:
                    new adminDaoImpl().deleteUser();
                    System.out.println("信息显示完毕，请再次输入您的选择:");
                    System.out.println("==========1.查看用户信息=========");
                    System.out.println("==========2.重置用户信息=========");
                    System.out.println("==========3.增加用户============");
                    System.out.println("==========4.删除用户============");
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
