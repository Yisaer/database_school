package com.shu.databases.service;

import com.shu.databases.entity.Elective;
import com.shu.databases.entity.Open;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public interface ElectiveService {
    List<Elective> getElectiveListBySidAndSemester(String sId,String semester);
    boolean insertElectiveWithSidAndOpen(String sId,Open open);
    boolean updateElectiveWithTidAndGrade(Elective elective,int pscj,int kscj);
    boolean deleteElective(Elective elective);
    List<Elective> getElectiveListBySid(String sId);
    List<Elective> getElectiveListByTid(String tId);

    boolean updateElectiveWithTidAndGrade(Elective elective,int pscj,int kscj,double perventage);
}
