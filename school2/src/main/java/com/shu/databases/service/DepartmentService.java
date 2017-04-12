package com.shu.databases.service;

import com.shu.databases.entity.Department;

import java.util.List;

/**
 * Created by Yisa on 2017/4/6.
 */
public interface DepartmentService {

    List<Department> getDepartmentList();
    Department getDepartmentByDid(String dId);

}
