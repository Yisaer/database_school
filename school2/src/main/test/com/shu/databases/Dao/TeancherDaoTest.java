package com.shu.databases.Dao;

import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yisa on 2017/4/3.
 */
public class TeancherDaoTest {

    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }


    @Test
    public void getTeacher() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacher("9999");
        if(teacher == null){
            System.out.println("没查到");
        }
    }

    @Test
    public void insertTeacher() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        try {
            Teacher teacher = new Teacher("9999","你好");
            teacherDao.insertTeacher(teacher);
            sqlSession.commit();
            System.out.println("insert Success");
        }finally {

            sqlSession.close();
        }
    }

    @Test
    public void updateTeacher() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        try {
            Teacher teacher = new Teacher("9999","我好");
            teacherDao.updateTeacher(teacher);
            sqlSession.commit();
            System.out.println("update Success");
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteTeacher() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        try {
            teacherDao.deleteTeacher("9999");
            sqlSession.commit();
            System.out.println("delete Success");
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void getTeacherList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacherList = teacherDao.getTeacherList();
        for(Teacher teacher:teacherList){
            System.out.println(teacher.gettName());
        }
    }
}