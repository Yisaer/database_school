package com.shu.databases.service.impl;

import com.shu.databases.Dao.TeacherDao;
import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Teacher;
import com.shu.databases.service.TeacherService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */
public class TeacherServiceImpl implements TeacherService{

    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Teacher> getTeacherList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacherList = teacherDao.getTeacherList();
        return teacherList;
    }

    public Teacher getTeacherById(String tId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacher(tId);
        return teacher;
    }

    public boolean Login(String tId, String tPwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacherList = teacherDao.getTeacherList();
        for( Teacher teacher : teacherList){
            if(teacher.gettId().equals(tId)
                    && teacher.gettPwd().equals(tPwd)){
                return true;
            }
        }
        return false;
    }
}
