package com.shu.databases.service.impl;

import com.shu.databases.Dao.OpenDao;
import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Open;
import com.shu.databases.service.OpenService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public class OpenServiceImpl implements OpenService {

    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Open> getOpenList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        return openDao.getOpenList();
    }

    public void insertOpen(Open open) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        try{
            openDao.insertOpen(open);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public void deleteOpen(Open open) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        try{
            openDao.deleteOpen(open);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public Open getOpenByCidAndTid(String cId,String tId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        List<Open> openList = openDao.getOpenList();
        for(Open open:openList){
            if(open.getcId().equals(cId)
                    && open.gettId().equals(tId)){
                return open;
            }
        }
        return null;
    }

    public Open getOpenByCidAndTidSemester(String cId, String tId, String semester) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        List<Open> openList = openDao.getOpenList();
        for(Open open:openList){
            if(open.getcId().equals(cId)
                    && open.gettId().equals(tId)
                    && open.getSemester().equals(semester)){
                return open;
            }
        }
        return null;
    }

    public List<Open> getOpenListByCid(String cId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        List<Open> openList = openDao.getOpenList();
        List<Open> res = new ArrayList<Open>();
        for(Open open:openList){
            if(open.getcId().equals(cId)){
                res.add(open);
            }
        }
        return res;
    }
}
