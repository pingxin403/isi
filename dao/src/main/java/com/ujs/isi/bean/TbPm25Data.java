package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TbPm25Data extends BaseBean<BigDecimal> {

    private BigDecimal did;

    private double pm25;
    private Timestamp date;


    public TbPm25Data() {
    }

    public TbPm25Data(BigDecimal did, double pm25, Timestamp date) {
        this.did = did;
        this.pm25 = pm25;
        this.date = date;
    }


    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
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
