package com.tykjdx.dao;

import com.tykjdx.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author 谭玥珩
 * @Date 2021/3/19 8:49
 * @Version 1.8
 * @简介：
 */
public interface StudentDao {
     void insert(Student student);
     Student selectByIdAndAge(@Param("id") Integer id ,@Param("age") Integer age);
     List<Student> selectByClassId(Map map);

     List<Map<String, Object>> selectByMap();
}
