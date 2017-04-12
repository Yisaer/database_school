package com.shu.databases.Dao;

import com.shu.databases.entity.Department;

import java.util.List;

/**
 * Created by Yisa on 2017/4/6.
 */
public interface DepartmentDao {
    List<Department> getDepartmentList();
    Department getDepartmentByDid(String dId);
}
