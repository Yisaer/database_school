package com.shu.databases.Dao;

import com.shu.databases.entity.Elective;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public interface ElectiveDao {
    List<Elective> getElectiveList();
    void insertElective( Elective elective);
    void deleteElective( Elective elective);
    void updateElective( Elective elective);
}
