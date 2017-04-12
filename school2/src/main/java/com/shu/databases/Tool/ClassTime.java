package com.shu.databases.Tool;

import java.util.ArrayList;

/**
 * Created by Yisa on 2017/4/7.
 */
public class ClassTime {

    private ArrayList<DayTime> period;

    public ClassTime() {
    }

    public ClassTime(ArrayList<DayTime> period) {
        this.period = period;
    }

    public ArrayList<DayTime> getPeriod() {
        return period;
    }

    public void setPeriod(ArrayList<DayTime> period) {
        this.period = period;
    }

    @Override
    public String toString() {
        String s = "";
        for(DayTime dayTime :period){
            s+=dayTime.getDay() +","+dayTime.getStart()+","+dayTime.getEnd()+"\n";
        }
        return s;
    }
}
