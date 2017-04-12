package com.shu.databases.Dao;

import com.shu.databases.entity.Teacher;

import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */
public interface TeacherDao {
    Teacher getTeacher(String tId);
    List<Teacher> getTeacherList();
    void insertTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(String tId);
}
