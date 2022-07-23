package com.HZ_A9.entities;
import com.HZ_A9.mysql.teacher.teacherDaoImpl.teacherDaoImpl;
import java.util.ArrayList;

public class Teacher {
    private int tId;
    private String tNo;
    private String tName;
    private String tSex;
    private String tTel;
    private String tOffice;
    private String tBranch;
    private String tPassword;

    public Teacher() {
    }

    public Teacher(int tId, String tNo, String tName,
                   String tSex, String tTel, String tOffice,
                   String tBranch, String tPassword) {
        this.tId = tId;
        this.tNo = tNo;
        this.tName = tName;
        this.tSex = tSex;
        this.tTel = tTel;
        this.tOffice = tOffice;
        this.tBranch = tBranch;
        this.tPassword = tPassword;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public String gettTel() {
        return tTel;
    }

    public void settTel(String tTel) {
        this.tTel = tTel;
    }

    public String gettOffice() {
        return tOffice;
    }

    public void settOffice(String tOffice) {
        this.tOffice = tOffice;
    }

    public String gettBranch() {
        return tBranch;
    }

    public void settBranch(String tBranch) {
        this.tBranch = tBranch;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + tId +
                ", tNo='" + tNo + '\'' +
                ", tName='" + tName + '\'' +
                ", tSex='" + tSex + '\'' +
                ", tTel='" + tTel + '\'' +
                ", tOffice='" + tOffice + '\'' +
                ", tBranch='" + tBranch + '\'' +
                ", tPassword='" + tPassword + '\'' +
                '}';
    }
}
