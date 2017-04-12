package com.shu.databases.Tool;

/**
 * Created by Yisa on 2017/4/7.
 */
public class DayTime {
    private int day;
    private int start;
    private int end;

    public DayTime(int day, int start, int end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public DayTime(String s){
        String s1 = s.substring(0,3);
        String s2 = s.substring(3);
        ClassHelper classHelper = new ClassHelper();
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
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
