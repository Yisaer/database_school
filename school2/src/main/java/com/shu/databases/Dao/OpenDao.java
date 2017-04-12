package com.shu.databases.Dao;

import com.shu.databases.entity.Open;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public interface OpenDao {
    List<Open> getOpenList();
    void insertOpen (Open open);
    void deleteOpen (Open open);
}
