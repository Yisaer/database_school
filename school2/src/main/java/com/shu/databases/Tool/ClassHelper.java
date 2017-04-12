package com.shu.databases.Tool;

import java.util.ArrayList;

/**
 * Created by Yisa on 2017/4/7.
 */
public class ClassHelper {

    public ClassTime getClassTimeByString(ArrayList<String> stringArrayList){
        ClassTime classTime = new ClassTime();
        ArrayList<DayTime> dayTimeArrayList = new ArrayList<DayTime>();
        for(String s :stringArrayList){
            String s1 = s.substring(0,3);
            String s2 = s.substring(3);
            DayTime dayTime = getDayTimeByTwoString(s1,s2);
            dayTimeArrayList.add(dayTime);
        }
        classTime.setPeriod(dayTimeArrayList);
        return classTime;
    }

    public DayTime getDayTimeByTwoString(String s1,String s2){
        int day  = 0;
        char[] chararr1 = s1.toCharArray();
        switch (chararr1[2]){
            case '一':day = 1;break;
            case '二':day = 2;break;
            case '三':day = 3;break;
            case '四':day = 4;break;
            case '五':day = 5;break;
            default:day = 0; break;
        }
        String[] num = s2.split("-");

        int start = Integer.parseInt(num[0]);
        int end = Integer.parseInt(num[1]);

        DayTime dayTime = new DayTime(day,start,end);
        return dayTime;
    }

    public void PrintArr2(boolean[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+",");
            }
            System.out.println("");
        }
    }

    public boolean IsConflict(ArrayList<ClassTime> arrayList ,ClassTime classTime){
        boolean isConflict = false;
        boolean[][] Table = new boolean[14][6];

        for(int i = 0;i<Table.length;i++){

            for(int j = 0;j<Table[i].length;j++){
//                System.out.println("i = "+i +",j = "+j);
                Table[i][j] = false;
            }
        }
        for(ClassTime c:arrayList){
            for(DayTime d:c.getPeriod()){
                int day = d.getDay();
                int start = d.getStart();
                int end = d.getEnd();
                System.out.println("d = "+day +" start = "+start+" end = "+end);
                for(int j =start ;j<=end;j++){
                    Table[j][day] = true;
                }
            }
        }
//        PrintArr2(Table);
        for(DayTime d: classTime.getPeriod()){
            int day = d.getDay();
            int start = d.getStart();
            int end = d.getEnd();
            for(int j = start;j<=end;j++){
                if(Table[j][day] == true){
                    isConflict = true;
                    break;
                }
            }
        }

        return isConflict ;
    }
}
