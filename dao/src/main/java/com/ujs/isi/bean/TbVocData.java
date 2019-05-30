package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TbVocData extends BaseBean<BigDecimal> {

    private BigDecimal did;
    private double voc;

    private Timestamp date;


    public TbVocData() {
    }

    public TbVocData(BigDecimal did, double voc, Timestamp date) {
        this.did = did;
        this.voc = voc;
        this.date = date;
    }


    public double getVoc() {
        return voc;
    }

    public void setVoc(double voc) {
        this.voc = voc;
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
