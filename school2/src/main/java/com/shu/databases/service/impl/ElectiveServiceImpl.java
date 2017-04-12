package com.shu.databases.service.impl;


import com.shu.databases.Dao.ElectiveDao;
import com.shu.databases.Dao.OpenDao;
import com.shu.databases.Tool.ClassHelper;
import com.shu.databases.Tool.ClassTime;
import com.shu.databases.dbaccess.DBAccess;
import com.shu.databases.entity.Elective;
import com.shu.databases.entity.Open;
import com.shu.databases.service.ElectiveService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisa on 2017/4/5.
 */
public class ElectiveServiceImpl implements ElectiveService{
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Elective> getElectiveListBySidAndSemester(String sId, String semester) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Elective> result = new ArrayList<Elective>();
        for(Elective elective : electiveList){
            if(elective.getSemester().equals(semester)&& elective.getsId().equals(sId)){
                result.add(elective);
            }
        }
        return result;
    }

    public boolean insertElectiveWithSidAndOpen(String sId, Open open) {
        System.out.println("sid = " + sId);
        System.out.println("open = " + open.getSemester()+","+open.getcId()+","+open.gettId()+","+open.getcTime());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        OpenServiceImpl openService = new OpenServiceImpl();

        List<Elective> electiveListTotal = electiveDao.getElectiveList();
        ArrayList<Elective> electiveList = new ArrayList<Elective>();
        for( Elective elective : electiveListTotal){
            if(elective.getSemester().equals(open.getSemester())
                    && elective.getsId().equals(sId))
                electiveList.add(elective);
        }

//        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Open> openList = openService.getOpenList();
        ClassHelper classHelper = new ClassHelper();
        boolean Exist = false;
        for(Open open1 :openList){
            if(open.getcId().equals(open1.getcId())
                    && open.gettId().equals(open1.gettId())
                    && open.getSemester().equals(open1.getSemester())){
                Exist = true;
                break;
            }
        }
        if(!Exist){
            return false;
        }
        System.out.println(" Exist ");
        boolean ChooseYet = false;
        for(Elective elective:electiveList){
            if(elective.getsId().equals(sId)
                    && elective.getSemester().equals(open.getSemester())
                    && elective.getcId().equals(open.getcId())
                    && elective.gettId().equals(open.gettId())){
                ChooseYet = true;
                break;
            }
        }
        if( ChooseYet == true){
            return false;
        }
        System.out.println(" Havent Choose ");

        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<ClassTime> classTimeArrayList = new ArrayList<ClassTime>();


        for(Elective elective : electiveList){
            if(elective.getsId().equals(sId)){
                Open o = null;
                for(Open o1 : openList){
                    if(o1.getcId().equals(elective.getcId())
                            && o1.gettId().equals(elective.gettId())
                            && o1.getSemester().equals(elective.getSemester())){
                        o = o1;
                        break;
                    }
                }
                String ctime = o.getcTime();
                ArrayList<String> s = new ArrayList<String>();
                s.add(ctime);
                ClassTime classTime  = classHelper.getClassTimeByString(s);
                classTimeArrayList.add(classTime);
            }
        }
        ArrayList<String> sOpen = new ArrayList<String>();
        sOpen.add(open.getcTime());
        ClassTime classTime = classHelper.getClassTimeByString(sOpen);
        boolean isConflict = classHelper.IsConflict(classTimeArrayList,classTime);
        if(isConflict){
            return false;
        }

        System.out.println(" not Conlict ");

        try{
            Elective elective = new Elective(sId,open);
            electiveDao.insertElective(elective);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return  true;
    }

    public boolean updateElectiveWithTidAndGrade(Elective elective, int pscj, int kscj) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        elective.setPscj(pscj);
        elective.setKscj(kscj);
        List<Elective> electiveList = electiveDao.getElectiveList();
        boolean Found = false;
        for(Elective e: electiveList){
            if(e.getsId().equals(elective.getsId())
                    && e.gettId().equals(elective.gettId())
                    && e.getSemester().equals(elective.getSemester())
                    && e.getcId().equals(elective.getcId())){
                Found = true;
            }
        }
        if(!Found){
            return false;
        }

        try{
            electiveDao.updateElective(elective);
            sqlSession.commit();
            // 获取记录 判断是否相等

        }finally {
            sqlSession.close();
        }
        return true;
    }

    public boolean deleteElective(Elective elective) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        boolean ChooseYes = false;
        for(Elective e : electiveList){
            if(e.getsId().equals(elective.getsId())
            && e.getcId().equals(elective.getcId())
            && e.getSemester().equals(elective.getSemester())
            && e.gettId().equals(elective.gettId())){
                ChooseYes = true;
            }
        }
        if(!ChooseYes){
            return false;
        }
        try{
            electiveDao.deleteElective(elective);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return true;
    }

    public List<Elective> getElectiveListBySid(String sId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Elective> result = new ArrayList<Elective>();
        for(Elective elective : electiveList){
            if(elective.getsId().equals(sId)){
                result.add(elective);
            }
        }
        return result;
    }

    public List<Elective> getElectiveListByTid(String tId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Elective> result = new ArrayList<Elective>();
        for(Elective elective : electiveList){
            if(elective.gettId().equals(tId)){
                result.add(elective);
            }
        }
        return result;
    }

    public boolean updateElectiveWithTidAndGrade(Elective elective, int pscj, int kscj, double perventage) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        elective.setPscj(pscj);
        elective.setKscj(kscj);
        int zpcj = (int)(pscj*perventage + kscj*(1-perventage));
        elective.setZpcj(zpcj);
        List<Elective> electiveList = electiveDao.getElectiveList();
        boolean Found = false;
        for(Elective e: electiveList){
            if(e.getsId().equals(elective.getsId())
                    && e.gettId().equals(elective.gettId())
                    && e.getSemester().equals(elective.getSemester())
                    && e.getcId().equals(elective.getcId())){
                Found = true;
            }
        }
        if(!Found){
            return false;
        }

        try{
            electiveDao.updateElective(elective);
            sqlSession.commit();
            // 获取记录 判断是否相等

        }finally {
            sqlSession.close();
        }
        return true;
    }
}
