package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TbPm10Data extends BaseBean<BigDecimal> {

    private BigDecimal did;

    private double pm10;
    private Timestamp date;


    public TbPm10Data() {
    }

    public TbPm10Data(BigDecimal did, double pm10, Timestamp date) {
        this.did = did;
        this.pm10 = pm10;
        this.date = date;
    }


    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public Long getDid() {
        return did.longValue();
    }

    public void setDid(Long did) {
        this.did = BigDecimal.valueOf(did);
    }
}
