package com.HZ_A9.entities;

public class Course {
    private int cId;
    private String cNo;
    private String cName;
    private String cBranch;//所属分院
    private String cAddress;//上课地址
    private int cAmount;//课时
    private int cAllowance;//选课余量
    private String tNo;//授课教师号

    public Course() {
    }

    public Course(int cId, String cNo, String cName, String cBranch,
                  String cAddress, int cAmount, int cAllowance, String tNo) {
        this.cId = cId;
        this.cNo = cNo;
        this.cName = cName;
        this.cBranch = cBranch;
        this.cAddress = cAddress;
        this.cAmount = cAmount;
        this.cAllowance = cAllowance;
        this.tNo = tNo;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcBranch() {
        return cBranch;
    }

    public void setcBranch(String cBranch) {
        this.cBranch = cBranch;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public int getcAmount() {
        return cAmount;
    }

    public void setcAmount(int cAmount) {
        this.cAmount = cAmount;
    }

    public int getcAllowance() {
        return cAllowance;
    }

    public void setcAllowance(int cAllowance) {
        this.cAllowance = cAllowance;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cNo='" + cNo + '\'' +
                ", cName='" + cName + '\'' +
                ", cBranch='" + cBranch + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cAmount=" + cAmount +
                ", cAllowance=" + cAllowance +
                ", tNo='" + tNo + '\'' +
                '}';
    }
}
