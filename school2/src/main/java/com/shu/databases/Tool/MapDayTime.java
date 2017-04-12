package com.shu.databases.Tool;

import java.util.ArrayList;

/**
 * Created by Yisa on 2017/4/9.
 */
public class MapDayTime {
    private char mapper;
    private ArrayList<DayTime> dayTimeArrayList;

    public MapDayTime() {
    }

    public MapDayTime(char mapper, ArrayList<DayTime> dayTimeArrayList) {
        this.mapper = mapper;
        this.dayTimeArrayList = dayTimeArrayList;
    }

    public char getMapper() {
        return mapper;
    }

    public void setMapper(char mapper) {
        this.mapper = mapper;
    }

    public ArrayList<DayTime> getDayTimeArrayList() {
        return dayTimeArrayList;
    }

    public void setDayTimeArrayList(ArrayList<DayTime> dayTimeArrayList) {
        this.dayTimeArrayList = dayTimeArrayList;
    }
}
