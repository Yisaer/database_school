package com.shu.databases.service;

import com.shu.databases.entity.Course;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public interface CourseService  {
    Course getCourseById(String cId);
    List<Course> getCourseList();
}
