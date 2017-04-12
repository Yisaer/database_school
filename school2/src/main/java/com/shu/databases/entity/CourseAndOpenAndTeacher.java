package com.shu.databases.entity;

/**
 * Created by Yisa on 2017/4/6.
 */
public class CourseAndOpenAndTeacher {
    private Course course;
    private Open open;
    private Teacher teacher;

    public CourseAndOpenAndTeacher(Course course, Open open, Teacher teacher) {
        this.course = course;
        this.open = open;
        this.teacher = teacher;
    }

    public CourseAndOpenAndTeacher() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Open getOpen() {
        return open;
    }

    public void setOpen(Open open) {
        this.open = open;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
