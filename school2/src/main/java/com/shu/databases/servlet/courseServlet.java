package com.shu.databases.servlet;

import com.shu.databases.entity.Course;
import com.shu.databases.entity.CourseAndOpenAndTeacher;
import com.shu.databases.entity.Open;
import com.shu.databases.entity.Teacher;
import com.shu.databases.service.CourseService;
import com.shu.databases.service.impl.CourseServiceImpl;
import com.shu.databases.service.impl.OpenServiceImpl;
import com.shu.databases.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisa on 2017/4/6.
 */
@WebServlet("/course")
public class courseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        CourseServiceImpl courseService = new CourseServiceImpl();
        OpenServiceImpl openService = new OpenServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        List<CourseAndOpenAndTeacher> ResList = new ArrayList<CourseAndOpenAndTeacher>();
        List<Open> openList = null;
        List<Teacher> teacherList = null;
        List<Course> courseList = null;

        long startMill = System.currentTimeMillis();
        HttpSession  session =request.getSession();



        if((openList = (List<Open>)session.getAttribute("openList"))== null){
            openList = openService.getOpenList();
            session.setAttribute("openList",openList);
        }

        if( (teacherList = (List<Teacher>)session.getAttribute("teacherList"))==null){
            teacherList = teacherService.getTeacherList();
            session.setAttribute("teacherList",teacherList);
        }
        if((courseList = (List<Course>) session.getAttribute("courseList"))==null){
            courseList = courseService.getCourseList();
            session.setAttribute("courseList",courseList);
        }
        for(Open open :openList){
            Course c = null;
            for(Course course : courseList){
                if( course.getcId().equals(open.getcId())){
                    c = course;
                    break;
                }
            }
            Teacher t = null;
            for(Teacher teacher : teacherList){
                if( teacher.gettId().equals(open.gettId())){
                    t = teacher;
                    break;
                }
            }
            CourseAndOpenAndTeacher courseAndOpenAndTeacher = new CourseAndOpenAndTeacher(c, open,t);
            if(courseAndOpenAndTeacher.getOpen().getSemester().equals("2016-2017春季")){
                ResList.add(courseAndOpenAndTeacher);
            }

        }
        long endMill = System.currentTimeMillis();
        System.out.println(endMill - startMill + "ms");
        session.setAttribute("ResList",ResList);
    }
}
