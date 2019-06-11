package com.ujs.isi.bean;


import com.ujs.isi.commons.BaseBean;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TbTravel extends BaseBean<BigDecimal> {

    private BigInteger sid;
    private java.sql.Date departureTime;
    private java.sql.Date returnTime;
    private String destination;
    private String objective;
    private String vehicle;





    public java.sql.Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(java.sql.Date departureTime) {
        this.departureTime = departureTime;
    }


    public java.sql.Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(java.sql.Date returnTime) {
        this.returnTime = returnTime;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }


    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }


    public BigInteger getSid() {
        return sid;
    }

    public void setSid(BigInteger sid) {
        this.sid = sid;
    }
}
