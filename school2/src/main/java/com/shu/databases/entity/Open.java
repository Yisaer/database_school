package com.shu.databases.entity;

/**
 * Created by Yisa on 2017/4/3.
 */
public class Open {


    private String semester;
    private String cId;
    private String tId;
    private String cTime;

    public Open(){

    }
    public Open(String semester, String cId, String tId, String cTime) {
        this.semester = semester;
        this.cId = cId;
        this.tId = tId;
        this.cTime = cTime;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }
}
