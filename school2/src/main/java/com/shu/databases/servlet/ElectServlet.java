package com.shu.databases.servlet;

import com.shu.databases.Tool.CourseTableRow;
import com.shu.databases.Tool.MapElective;
import com.shu.databases.Tool.StudentLogin;
import com.shu.databases.entity.*;
import com.shu.databases.service.OpenService;
import com.shu.databases.service.impl.ElectiveServiceImpl;
import com.shu.databases.service.impl.OpenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisa on 2017/4/6.
 */
@WebServlet("/Elect")
public class ElectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String cId = request.getParameter("cId");
        String tId = request.getParameter("tId");
        Student student =(Student) request.getSession().getAttribute("student");

        OpenServiceImpl openService = new OpenServiceImpl();
        Open open = openService.getOpenByCidAndTidSemester(cId,tId,"2016-2017春季");
        if(open !=null){
            ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
            long startTime = System.currentTimeMillis();
            boolean success = electiveService.insertElectiveWithSidAndOpen(student.getsId(),open);
            long endTime = System.currentTimeMillis();
            System.out.println("InsertTime Cost " + (endTime-startTime) +"ms" );
            if(success){
                request.getSession().setAttribute("stat","选课成功");
            }else{
                request.getSession().setAttribute("stat","选课失败");
            }

        }else{
            request.getSession().setAttribute("stat","选课失败");
        }
        long s = System.currentTimeMillis();
        StudentLogin.CourseTableFunction(request,student.getsId());
        long e = System.currentTimeMillis();
        System.out.println(" CourseTable Cost " + (e-s) +"ms");
        response.sendRedirect("/student.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
