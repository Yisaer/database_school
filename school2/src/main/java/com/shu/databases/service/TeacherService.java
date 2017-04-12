package com.shu.databases.service;

import com.shu.databases.entity.Teacher;

import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */
public interface TeacherService  {
    List<Teacher> getTeacherList();
    Teacher getTeacherById(String tId);
    boolean Login(String tId,String tPwd);
}
