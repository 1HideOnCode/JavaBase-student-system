package com.HZ_A9.entities;
import com.HZ_A9.views.loginPage;
import java.util.ArrayList;
import java.util.Scanner;
import com.HZ_A9.utils.md5Util;
import com.HZ_A9.utils.checkSourcePwd;
public class Student {
    private int sId;
    private String sNo;
    private String name;
    private String sSex;
    private String sDate;
    private String sTel;
    private String sAddress;
    private String sPassword;

    public Student() {
    }

    public Student(int sId, String sNo,String name, String sSex, String sDate, String sTel, String sAddress, String sPassword) {
        this.sId = sId;
        this.sNo = sNo;
        this.name = name;
        this.sSex = sSex;
        this.sDate = sDate;
        this.sTel = sTel;
        this.sAddress = sAddress;
        this.sPassword = sPassword;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sNo='" + sNo + '\'' +
                ", name='" + name + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sDate='" + sDate + '\'' +
                ", sTel='" + sTel + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sPassword='" + sPassword + '\'' +
                '}';
    }

    public Student getStudentBySno(int sId){
        return new Student();
    }
    public Student updatePassword(Student student) {
        checkSourcePwd checkSourcePwd = new checkSourcePwd();
        boolean flag = checkSourcePwd.checkSourceStucherPwd();
        if(flag){
            System.out.println("请输入您的新密码:");
            Scanner sc = new Scanner(System.in);
            String newPwd1 = sc.nextLine();
            System.out.println("请确认您的新密码:");
            String newPwd2 = sc.nextLine();
            flag = newPwd1.equals(newPwd2) ? true : false;
            if(flag){

                newPwd1 = md5Util.getMD5Str(newPwd1);
                System.out.println("修改成功，但新密码还未插入数据库");
                student.setsPassword(newPwd1);
                return student;
            }else{
                System.out.println("修改失败，且新密码还未插入数据库");
                return student;
            }
        }
        return student;
    }
    public ArrayList<Course> getCourse(){
        return new ArrayList<Course>();
    }
    public boolean chooseCourse(String cId){
    return true;
    }
}
