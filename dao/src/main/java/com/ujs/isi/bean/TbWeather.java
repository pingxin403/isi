package com.ujs.isi.bean;

import com.ujs.isi.commons.BaseBean;

import java.math.BigInteger;

public class TbWeather extends BaseBean<BigInteger> {

    private String weather;
    private java.sql.Date wdate;
    private String wlocate;


    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }


    public java.sql.Date getWdate() {
        return wdate;
    }

    public void setWdate(java.sql.Date wdate) {
        this.wdate = wdate;
    }


    public String getWlocate() {
        return wlocate;
    }

    public void setWlocate(String wlocate) {
        this.wlocate = wlocate;
    }


}
