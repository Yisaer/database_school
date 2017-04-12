package com.shu.databases.entity;

/**
 * Created by Yisa on 2017/4/3.
 */
public class Elective {
    private String sId;
    private String semester;
    private String cId;
    private String tId;
    private Integer pscj;
    private Integer kscj;
    private Integer zpcj;

    public Elective(){

    }

    public Elective(String sId, String semester, String cId, String tId, Integer pscj, Integer kscj, Integer zpcj) {
        this.sId = sId;
        this.semester = semester;
        this.cId = cId;
        this.tId = tId;
        this.pscj = pscj;
        this.kscj = kscj;
        this.zpcj = zpcj;
    }

    public Elective(String sId , Open open){
        this.sId = sId;
        this.semester = open.getSemester();
        this.cId = open.getcId();
        this.tId = open.gettId();
        this.zpcj = null;
        this.pscj = null;
        this.kscj = null;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
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

    public Integer getPscj() {
        return pscj;
    }

    public void setPscj(Integer pscj) {
        this.pscj = pscj;
    }

    public Integer getKscj() {
        return kscj;
    }

    public void setKscj(Integer kscj) {
        this.kscj = kscj;
    }

    public Integer getZpcj() {
        return zpcj;
    }

    public void setZpcj(Integer zpcj) {
        this.zpcj = zpcj;
    }
}
