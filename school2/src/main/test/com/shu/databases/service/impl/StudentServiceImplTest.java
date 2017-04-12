package com.shu.databases.service.impl;

import com.shu.databases.Dao.StudentDao;
import com.shu.databases.entity.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yisa on 2017/4/3.
 */
public class StudentServiceImplTest {
    private static StudentDao studentDao;
    @Test
    public void getStudentList() throws Exception {
        List<Student> studentlist = studentDao.getStudentList();
        for(Student student:studentlist){
            System.out.println(student.getsName());
        }
    }

    @Test
    public void getStudentById() throws Exception {

    }

}