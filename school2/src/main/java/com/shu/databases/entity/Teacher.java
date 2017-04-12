package com.shu.databases.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Yisa on 2017/4/3.
 */
public class Teacher {

    private String tId;
    private String tPwd;
    private String tName;
    private String tGender;
    private Date tBirthday;
    private String position;
    private BigDecimal salary;
    private String dId;

    public Teacher(String tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public Teacher(String tId, String tPwd, String tName, String tGender, Date tBirthday, String position, BigDecimal salary, String dId) {
        this.tId = tId;
        this.tPwd = tPwd;
        this.tName = tName;
        this.tGender = tGender;
        this.tBirthday = tBirthday;
        this.position = position;
        this.salary = salary;
        this.dId = dId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettPwd() {
        return tPwd;
    }

    public void settPwd(String tPwd) {
        this.tPwd = tPwd;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettGender() {
        return tGender;
    }

    public void settGender(String tGender) {
        this.tGender = tGender;
    }

    public Date gettBirthday() {
        return tBirthday;
    }

    public void settBirthday(Date tBirthday) {
        this.tBirthday = tBirthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }
}
