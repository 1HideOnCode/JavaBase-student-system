package com.HZ_A9.entities;

import java.util.ArrayList;

public class Admin {
    String userNo;
    String userPassword;
    int level;

    public Admin() {
    }

    public Admin(String userNo, String userPassword, int level) {
        this.userNo = userNo;
        this.userPassword = userPassword;
        this.level = level;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public boolean loginSystem(Admin admin){
        return true;
    }
    public ArrayList<Admin> getUserInfo(){
        return new ArrayList<>();
    }
    public void printUser(ArrayList<Admin> users){
        /*
        打印权限信息
         */
    }
    public boolean resetPassword(String uNo){
        return true;
    }
    public boolean addAdmin(String uNo,int ulevel){
        return true;
    }
    public boolean deleteAdmin(String uNo){
        return true;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userNo='" + userNo + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", level=" + level +
                '}';
    }
}
