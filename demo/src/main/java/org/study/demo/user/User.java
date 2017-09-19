package org.study.demo.user;

import java.util.Date;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class User {
    private String name;
    private String sex;
    private int age;
    private Date birthday;

    public User(String name, String sex, int age, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
