package com.shu.databases.service;

import com.shu.databases.entity.Open;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public interface OpenService {
    List<Open> getOpenList();
    void insertOpen(Open open);
    void deleteOpen(Open open);
    Open getOpenByCidAndTid(String cId,String tId);
    Open getOpenByCidAndTidSemester(String cId,String tId,String semester);
    List<Open> getOpenListByCid(String cId);

}
