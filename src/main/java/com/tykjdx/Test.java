package com.tykjdx;

import com.tykjdx.dao.StudentDao;
import com.tykjdx.domain.Student;
import com.tykjdx.service.Impl.StudentServiceImpl;
import com.tykjdx.service.StudentService;
import com.tykjdx.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @Author 谭玥珩
 * @Date 2021/3/19 8:56
 * @Version 1.8
 * @简介：
 */
public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student  =new Student(5,"ls","ls@qq.c",20);
        dao.insert(student);
        //sqlSession.commit();
    }
}
