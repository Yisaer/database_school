package com.shu.databases.entity;

/**
 * Created by Yisa on 2017/4/3.
 */
public class Course {

    private String cId;
    private String cName;
    private Integer credit;
    private Integer hours;
    private String dId;

    public Course(String cId, String cName, Integer credit, Integer hours, String dId) {
        this.cId = cId;
        this.cName = cName;
        this.credit = credit;
        this.hours = hours;
        this.dId = dId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }
}
