package com.shu.databases.service.impl;

import com.shu.databases.Dao.CourseDao;
import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Course;
import com.shu.databases.service.CourseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public class CourseServiceImpl implements CourseService {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }

    public Course getCourseById(String cId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.getCourse(cId);
    }

    public List<Course> getCourseList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.getCourseList();
    }
}
