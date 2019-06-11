package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TbDevices extends BaseBean<BigDecimal> {


    private String name;
    private String number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
