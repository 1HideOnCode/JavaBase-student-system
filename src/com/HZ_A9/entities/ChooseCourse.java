package com.HZ_A9.entities;

public class ChooseCourse {
    private int ccId;
    private String cNo;
    private String tNo;
    private String sNo;

    public ChooseCourse() {
    }

    public ChooseCourse(int ccId, String cNo, String tNo, String sNo) {
        this.ccId = ccId;
        this.cNo = cNo;
        this.tNo = tNo;
        this.sNo = sNo;
    }

    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    @Override
    public String toString() {
        return "ChooseCourse{" +
                "ccId=" + ccId +
                ", cNo='" + cNo + '\'' +
                ", tNo='" + tNo + '\'' +
                ", sNo='" + sNo + '\'' +
                '}';
    }
}
