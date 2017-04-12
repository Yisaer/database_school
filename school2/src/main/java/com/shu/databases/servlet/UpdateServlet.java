package com.shu.databases.servlet;

import com.shu.databases.entity.Elective;
import com.shu.databases.entity.Open;
import com.shu.databases.entity.Teacher;
import com.shu.databases.service.impl.ElectiveServiceImpl;
import com.shu.databases.service.impl.OpenServiceImpl;
import com.sun.org.apache.bcel.internal.generic.GOTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yisa on 2017/4/6.
 */
@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String tId = teacher.gettId();
        String cId = request.getParameter("cId");
        String sId = request.getParameter("sId");
        String p1 = request.getParameter("pscj");
        String p2 = request.getParameter("kscj");
        String PercentageOfPscj = request.getParameter("Percentage");

        ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
        if( p1 == null || p2 == null || p1.equals("") || p2.equals("")|| PercentageOfPscj == null || PercentageOfPscj.equals("")){
            request.getSession().setAttribute("updateStat","改分失败");
        }
        else{
            boolean b1 =true;
            boolean b2 = true;
            boolean b3 = true;
            for(int i = 0;i<p1.length();i++){
                char ch = p1.charAt(i);
                if(ch>'9'||ch<'0'){
                    request.getSession().setAttribute("updateStat","改分失败");
                    b1 = false;
                    break;
                }
            }
            for(int i = 0;i<p2.length();i++){
                char ch = p2.charAt(i);
                if(ch>'9'||ch<'0'){
                    request.getSession().setAttribute("updateStat","改分失败");
                    b2 = false;
                    break;
                }
            }
            for(int i = 0; i<PercentageOfPscj.length();i++){
                char ch  = PercentageOfPscj.charAt(i);
                if(i == 0 && ch !='0'){
//                    System.out.println("here1");
                    request.getSession().setAttribute("updateStat","改分失败");
                    b3 = false;
                    break;
                }
                else if( i == 1 && ch!='.'){
//                    System.out.println("here2");
                    request.getSession().setAttribute("updateStat","改分失败");
                    b3 = false;
                    break;
                }
                else if( (ch >'9' ||ch <'0')&& i >= 2){
//                    System.out.println("here3");
                    request.getSession().setAttribute("updateStat","改分失败");
                    b3= false;
                    break;
                }
            }
//            System.out.println("b1 = " + b1);
//            System.out.println("b2 = " + b2);
//            System.out.println("b3 = " + b3);
//            System.out.println("per = " + PercentageOfPscj);

            if(b1 && b2 && b3){
                int pscj = Integer.parseInt(p1);
                int kscj = Integer.parseInt(p2);
                double per = Double.parseDouble(PercentageOfPscj);
                OpenServiceImpl openService = new OpenServiceImpl();
                Open open = openService.getOpenByCidAndTid(cId,tId);
                if(open==null){
                    request.getSession().setAttribute("updateStat","改分失败");
                }else{
                    Elective elective = new Elective(sId,open);
                    boolean success = electiveService.updateElectiveWithTidAndGrade(elective,pscj,kscj,per);
                    if(success){
                        request.getSession().setAttribute("updateStat","改分成功");
                    }else{
                        request.getSession().setAttribute("updateStat","改分失败");
                    }
                }
            }
        }
        List<Elective> electiveList = electiveService.getElectiveListByTid(tId);
        request.getSession().setAttribute("teacher",teacher);
        request.getSession().setAttribute("electiveList",electiveList);
        response.sendRedirect("/teacher.jsp");
    }
}
