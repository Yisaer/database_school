package com.shu.databases.service;

import com.shu.databases.entity.Student;

import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */
public interface StudentService {
    List<Student> getStudentList();
    Student getStudentById(String sId);
    boolean Login(String sId, String sPwd);
}
