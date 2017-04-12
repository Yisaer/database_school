package com.shu.databases.Tool;

import com.shu.databases.entity.Elective;

/**
 * Created by Yisa on 2017/4/9.
 */
public class MapElective {
    private char mapper;
    private Elective elective;

    public MapElective(char mapper, Elective elective) {
        this.mapper = mapper;
        this.elective = elective;
    }

    public char getMapper() {
        return mapper;
    }

    public void setMapper(char mapper) {
        this.mapper = mapper;
    }

    public Elective getElective() {
        return elective;
    }

    public void setElective(Elective elective) {
        this.elective = elective;
    }
}
