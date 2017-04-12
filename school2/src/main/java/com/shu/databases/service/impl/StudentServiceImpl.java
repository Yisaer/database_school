package com.shu.databases.service.impl;

import com.shu.databases.Dao.StudentDao;
import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Student;
import com.shu.databases.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Yisa on 2017/4/3.
 */
public class StudentServiceImpl implements StudentService {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }


    public List<Student> getStudentList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        return studentDao.getStudentList();
    }

    public Student getStudentById(String sId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.getStudent(sId);
        return student;
    }

    public boolean Login(String sId, String sPwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.getStudent(sId);
        if(student == null){
            return false;
        }
        if(student.getsPwd().equals(sPwd)){
            return true;
        }
        return false;
    }
}
