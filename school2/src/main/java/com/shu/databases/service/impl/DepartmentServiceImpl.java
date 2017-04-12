package com.shu.databases.service.impl;

import com.shu.databases.Dao.DepartmentDao;
import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Department;
import com.shu.databases.service.DepartmentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Yisa on 2017/4/6.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Department> getDepartmentList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentDao departmentDao= sqlSession.getMapper(DepartmentDao.class);
        return departmentDao.getDepartmentList();
    }

    public Department getDepartmentByDid(String dId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentDao departmentDao= sqlSession.getMapper(DepartmentDao.class);
        return departmentDao.getDepartmentByDid(dId);
    }
}
