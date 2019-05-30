package com.ujs.isi.commons;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 基本数据库类
 *
 * @author hyp
 * Project name is ims
 * Include in com.ujs.ims.bean
 * hyp create at 2019/5/20
 **/
public abstract class BaseBean<T> {
    private T id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    public BaseBean() {
    }

    public BaseBean(T id, Timestamp gmtCreate, Timestamp gmtModified) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseBean)) return false;
        BaseBean baseBean = (BaseBean) o;
        return getId() == baseBean.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
