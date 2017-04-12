package com.shu.databases.entity;

/**
 * Created by Yisa on 2017/4/3.
 */
public class Department {
//      `dId` varchar(3) NOT NULL,
//  `dName` varchar(30) DEFAULT NULL,
//  `address` varchar(300) DEFAULT NULL,
//  `dPhone` char(15) DEFAULT NULL,
    private String dId;
    private String dName;
    private String address;
    private String dPhone;

    public Department(String dId, String dName, String address, String dPhone) {
        this.dId = dId;
        this.dName = dName;
        this.address = address;
        this.dPhone = dPhone;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }
}
