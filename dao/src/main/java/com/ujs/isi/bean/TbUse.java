package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TbUse extends BaseBean<BigDecimal> {

    private java.sql.Date date;
    private BigDecimal electricity;
    private BigDecimal water;


    public TbUse() {

    }

    public TbUse(BigDecimal electricity, BigDecimal water) {
        this.electricity = electricity;
        this.water = water;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public BigDecimal getElectricity() {
        return electricity;
    }

    public void setElectricity(BigDecimal electricity) {
        this.electricity = electricity;
    }

    public BigDecimal getWater() {
        return water;
    }

    public void setWater(BigDecimal water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "Use{" +
                "electricity=" + electricity +
                ", water=" + water +
                '}';
    }
}
