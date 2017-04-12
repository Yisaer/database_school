package com.shu.databases.Dao;

import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Yisa on 2017/4/3.
 */
public class StudentDaoTest {

    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }


}