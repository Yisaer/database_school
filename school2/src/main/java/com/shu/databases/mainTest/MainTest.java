package com.shu.databases.mainTest;

import com.shu.databases.Tool.ClassHelper;
import com.shu.databases.Tool.ClassTime;
import com.shu.databases.Tool.DayTime;
import com.shu.databases.entity.*;
import com.shu.databases.service.ElectiveService;
import com.shu.databases.service.TeacherService;
import com.shu.databases.service.impl.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */

/*

    这只是一个测试Main类,与项目无关。
 */
public class MainTest {
    public static void main(String[] argv){
        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl();
        OpenServiceImpl openService = new OpenServiceImpl();
        ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        ClassHelper classHelper = new ClassHelper();

        String s1 = "星期一1-4";
        String s2 = "星期一7-8";
        String s3 = "星期一5-6";
        ArrayList<String> strings1 = new ArrayList<String>();
        strings1.add(s1);
        ClassTime classTime1 = classHelper.getClassTimeByString(strings1);
        ArrayList<String> strings2 = new ArrayList<String>();
        strings2.add(s2);
        ClassTime classTime2 = classHelper.getClassTimeByString(strings2);
        ArrayList<ClassTime> classTimeArrayList = new ArrayList<ClassTime>();
        classTimeArrayList.add(classTime1);
        classTimeArrayList.add(classTime2);
        ArrayList<String> strings3 = new ArrayList<String>();
        strings3.add(s3);
        ClassTime classTime3 = classHelper.getClassTimeByString(strings3);

        boolean isConflict = classHelper.IsConflict(classTimeArrayList,classTime3);
        if(isConflict){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
//        ArrayList<String > strings1 = new ArrayList<String>();
//        strings1.add(s3);
//        boolean isConflict = classHelper.IsConflict()



//        List<Department> departmentList = departmentService.getDepartmentList();
//        for(Department department :departmentList){
//            System.out.println(department.getdId());
//        }
//        System.out.println(departmentService.getDepartmentByDid("01").getdName());



        // ElectiveService 测试 选课, 完成
//        Open open = new Open("2012-2013冬季","08305002","0101","星期三1-4");
//        Integer sId = new Integer(9989);
//        boolean success = electiveService.insertElectiveWithSidAndOpen(sId,open);
//        if(success){
//            System.out.println("Success");
//        }
//        else{
//            System.out.println("failed");
//        }

//        // Elective 测试,退课 完成
//
//        Elective elective = new Elective(new Integer(9989),open);
//        boolean success = electiveService.deleteElective(elective);
//        if(success){
//            System.out.println("success");
//        }else{
//            System.out.println("failded");
//        }
        // 登分 测试 完成
//        Open open = new Open("2012-2013冬季","08305002","0101","星期三1-4");
//        Elective elective = new Elective(new Integer(1102),open);
//        boolean succees = electiveService.updateElectiveWithTidAndGrade(elective,83,83,83);
//        if(succees){
//            System.out.println("Success");
//        }
//        else{
//            System.out.println("failed");
//        }

//        学生登录 完成
//        boolean success = studentService.Login(new Integer(1101),"1001");
//        if(success){
//            System.out.println("success");
//        }else{
//            System.out.println("failed");
//        }

//        老师登录 完成
//        boolean success = teacherService.Login("0102","0101");
//        if(success){
//            System.out.println("success");
//        }else{
//            System.out.println("failed");
//        }


//        List<Student> studentList = studentService.getStudentList();
//        for(Student student : studentList){
//            System.out.println(student.getsName());
//        }
//        Student student = studentService.getStudentById(1101);
//        System.out.println(student.getsName());
//        List<Teacher> teacherList = teacherService.getTeacherList();
//        for(Teacher teacher:teacherList){
//            System.out.println(teacher.gettName());
//        }
//        Teacher teacher = teacherService.getTeacherById("0101");
//        System.out.println(teacher.gettName());
//        Course course = courseService.getCourseById("08301001");
//        System.out.println(course.getcName());
//        List<Course> courseList = courseService.getCourseList();
//        for(Course course1 :courseList){
//            System.out.println(course1.getcName());
//        }
//        Open open = new Open("semester","cId","tId","cTime");
//        openService.insertOpen(open);
//        openService.deleteOpen(open);
//        List<Open> openList  = openService.getOpenList();
//        for(Open open1: openList){
//            System.out.println(open1.getcId());
//        }
//        List<Elective> electivelist = electiveService.getElectiveListBySidAndSemester(1103,"2013-2014秋季");
//        System.out.println("here"+electivelist.size());
//        for( Elective elective : electivelist){
//            System.out.println(elective.getsId() +","+elective.getSemester());
//        }
//        Open open = new Open("2012-2013冬季","08305002","0101","星期三1-4");
//        Integer sId = new Integer(9989);
//        electiveService.insertElectiveWithSidAndOpen(sId,open);
//        System.out.println("Success");

    }
}
