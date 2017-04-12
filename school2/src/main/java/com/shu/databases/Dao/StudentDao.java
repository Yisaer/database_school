package com.shu.databases.Dao;

import com.shu.databases.entity.Student;

import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */
public interface StudentDao {
    Student getStudent(String sId);
    void insertStudent(Student student);
    void deleteStudent(String sId);
    void updateStudent(Student student);
    List<Student>  getStudentList();
}
