package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TbCo2Data extends BaseBean<BigDecimal> {

    private BigDecimal did;
    private double co2;
    private Timestamp date;


    public TbCo2Data() {
    }

    public TbCo2Data(BigDecimal did, double co2, Timestamp date) {
        this.did = did;
        this.co2 = co2;
        this.date = date;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
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
