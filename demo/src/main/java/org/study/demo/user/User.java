package org.study.demo.user;

import java.util.Date;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class User {
    private String name;
    private String sex;
    private Integer age;
    private Date birthday;

    public User(){

    }
    public User(String name, String sex, Integer age, Date birthday) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
