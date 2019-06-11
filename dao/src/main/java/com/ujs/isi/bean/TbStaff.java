package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TbStaff extends BaseBean<BigDecimal> {

    private String name;
    private long age;
    private long sex;
    private java.sql.Date wHours;
    private long salary;
    private String position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }


    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }


    public java.sql.Date getWHours() {
        return wHours;
    }

    public void setWHours(java.sql.Date wHours) {
        this.wHours = wHours;
    }


    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
