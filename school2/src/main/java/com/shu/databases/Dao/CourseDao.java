package com.shu.databases.Dao;

import com.shu.databases.entity.Course;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public interface CourseDao {
    Course getCourse(String cId);
    List<Course> getCourseList();
    void insertCourse(Course course);
    void deleteCourse(String cId);
    void updateCourse(Course course);
}
