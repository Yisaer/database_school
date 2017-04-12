package com.shu.databases.entity;


import java.sql.Date;

/**
 * Created by Yisa on 2017/4/3.
 */
public class Student {

    private String sId;
    private String sPwd;
    private String sName;
    private String sGender;
    private Date sBirthday;
    private String city;
    private String sPhone;
    private String dId;

    public Student(String sId, String sPwd, String sName, String sGender, Date sBirthday, String city, String sPhone, String dId) {
        this.sId = sId;
        this.sPwd = sPwd;
        this.sName = sName;
        this.sGender = sGender;
        this.sBirthday = sBirthday;
        this.city = city;
        this.sPhone = sPhone;
        this.dId = dId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public Date getsBirthday() {
        return sBirthday;
    }

    public void setsBirthday(Date sBirthday) {
        this.sBirthday = sBirthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }
}
