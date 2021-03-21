package com.tykjdx.domain;

/**
 * @Author 谭玥珩
 * @Date 2021/3/19 8:50
 * @Version 1.8
 * @简介：
 */
public class Student {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student( Integer id,String name, String email, Integer age) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
