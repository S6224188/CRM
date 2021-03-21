package com.tykjdx;

import com.tykjdx.dao.StudentDao;
import com.tykjdx.domain.Student;
import com.tykjdx.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author 谭玥珩
 * @Date 2021/3/19 9:32
 * @Version 1.8
 * @简介：
 */
public class Test {
    @org.junit.Test
    public void insert() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(5, "ls", "ls@qq.c", 20);
        dao.insert(student);
        //sqlSession.commit();
    }

    @org.junit.Test
    public void selectByIdAndAge() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student=dao.selectByIdAndAge(2,20);
        System.out.println(student);
    }

    @org.junit.Test
    public void selectByClassId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,String> map = new HashMap();
        map.put("name","zhangsan");
        map.put("className","一年一");
        List<Student> list=dao.selectByClassId(map);
        list.forEach(student -> System.out.println(student));
    }

    @org.junit.Test
    public void selectByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Map<String,Object>> mapList=dao.selectByMap();
        /*
        * 底层实现原理是，通过数据库查到每一行的数据然后key和value装在一个map集合里,然后吧每一个map装在List里
        * 此时的Map集合就相当于一个实体类，key对应属性，value对应值
        * Map map1 = new HashMap();
        * map.put("id","1")
        * map.put("name","zhangsan")；
        * --------
        * List list = new ArrayList();
        * list.add(map1);
        * list.add(map2);
        * --------
        * */
        /*
        * 遍历map集合，拿到所有的key，通过key获取对应的value
        * */
        for(Map<String, Object> map:mapList){
            Set<String> allKey=map.keySet();
            for (String key:allKey){
                System.out.println("key:"+key+"  value:"+map.get(key));
            }
            System.out.println("--------------");
        }
    }
}
