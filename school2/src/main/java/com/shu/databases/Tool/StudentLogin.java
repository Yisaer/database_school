package com.shu.databases.Tool;

import com.shu.databases.entity.Elective;
import com.shu.databases.entity.Open;
import com.shu.databases.service.ElectiveService;
import com.shu.databases.service.impl.ElectiveServiceImpl;
import com.shu.databases.service.impl.OpenServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisa on 2017/4/9.
 */
public class StudentLogin {

    public static void CourseTableFunction(HttpServletRequest request,String username){
        ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
        OpenServiceImpl openService = new OpenServiceImpl();

        // STATE 1
        long s1 = System.currentTimeMillis();
        List<Elective> electiveList = electiveService.getElectiveListBySid(username);
        List<MapElective> mapElectiveList = new ArrayList<MapElective>();
        char ch = 'A';
        for( Elective elective : electiveList){
            if( elective.getSemester().equals("2016-2017春季")){
                MapElective mapElective = new MapElective(ch,elective);
                int chnum = (int)ch;
                chnum = chnum+1;
                ch = (char)chnum;

                mapElectiveList.add(mapElective);
            }
        }
        long e1 = System.currentTimeMillis();
        System.out.println(" stage 1 cost  = " + (e1-s1) +"ms");

        long sp = System.currentTimeMillis();
        List<Open> openList  = null;
        if( (openList =(ArrayList<Open>) request.getSession().getAttribute("openList")) == null){
            openList = openService.getOpenList();
        }
        long ep = System.currentTimeMillis();
        System.out.println("QueryList cost " +(ep-sp) +"ms");
//        List<Open>
        ClassHelper classHelper =new ClassHelper();
        ArrayList<MapDayTime> mapDayTimeList = new ArrayList<MapDayTime>();
        // STAGE 2
        long s2 =  System.currentTimeMillis();
        for( MapElective mapElective : mapElectiveList){
            long loopstart = System.currentTimeMillis();
            MapDayTime mapDayTime = new MapDayTime();
            String cTime = "";
            for(Open open : openList){
                if(mapElective.getElective().getcId().equals(open.getcId())
                        && mapElective.getElective().gettId().equals(open.gettId())){
                    cTime = open.getcTime();break;
                }
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add(cTime);
            ClassTime classTime = classHelper.getClassTimeByString(arrayList);
            ArrayList<DayTime> dayTimeArrayList = classTime.getPeriod();
            mapDayTime.setMapper(mapElective.getMapper());
            mapDayTime.setDayTimeArrayList(dayTimeArrayList);
            mapDayTimeList.add(mapDayTime);
            long loopend = System.currentTimeMillis();

            System.out.println(" Loop cost " + (loopend - loopend) +"ms");
        }
        long e2 =  System.currentTimeMillis();
        System.out.println(" stage s2 = " + (e2-s2)+ "ms");
        //STAGE 3

        long s3 =  System.currentTimeMillis();
        char[][] chars = new char [13][5];
        for(int i = 0; i<13;i++){
            for(int  j =0 ;j<5;j++){
                chars[i][j] = ' ';
            }
        }
        for(MapDayTime mapDayTime :mapDayTimeList){
            for(DayTime dayTime: mapDayTime.getDayTimeArrayList()){
                int d = dayTime.getDay()-1;
                int s = dayTime.getStart()-1;
                int e = dayTime.getEnd() -1;
                for(int  i = s; i<=e;i++){

                    chars[i][d] = mapDayTime.getMapper();
                }
            }
        }
        ArrayList<CourseTableRow> courseTableRowArrayList = new ArrayList<CourseTableRow>();
        for(int i = 0;i<13;i++){
            char[] subchars = new char[5];
            for(int j = 0;j<5;j++){
                subchars[j] = chars[i][j];
            }
            CourseTableRow courseTableRow = new CourseTableRow(subchars,i+1);
            courseTableRowArrayList.add(courseTableRow);
        }

        long e3 =  System.currentTimeMillis();
        System.out.println("s3 cost = "+ (e3-s3) +"ms");

        long s4 =  System.currentTimeMillis();
        //STAGE END
        request.getSession().setAttribute("CourseTable",courseTableRowArrayList);
        request.getSession().setAttribute("historyList",electiveList);
        request.getSession().setAttribute("MapElectiveList",mapElectiveList);
        long e4 =  System.currentTimeMillis();
        System.out.println(" stage s4 cost  = " +(e4-s4) +"ms");
    }
}
