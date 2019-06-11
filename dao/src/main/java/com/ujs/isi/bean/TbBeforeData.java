package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public class TbBeforeData extends BaseBean<BigDecimal> {

  private double co2;
  private double voc;
  private double pm25;
  private double pm10;
  private String wlocate;
  private java.sql.Date date;



  public double getCo2() {
    return co2;
  }

  public void setCo2(double co2) {
    this.co2 = co2;
  }


  public double getVoc() {
    return voc;
  }

  public void setVoc(double voc) {
    this.voc = voc;
  }


  public double getPm25() {
    return pm25;
  }

  public void setPm25(double pm25) {
    this.pm25 = pm25;
  }


  public double getPm10() {
    return pm10;
  }

  public void setPm10(double pm10) {
    this.pm10 = pm10;
  }


  public String getWlocate() {
    return wlocate;
  }

  public void setWlocate(String wlocate) {
    this.wlocate = wlocate;
  }


  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Data{" +
            "co2=" + co2 +
            ", voc=" + voc +
            ", pm25=" + pm25 +
            ", pm10=" + pm10 +
            '}';
  }
}
