package com.ujs.isi.commons;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.commons
 * hyp create at 2019/5/25
 **/
public class ResultCode {
    @JSONField(name = "code", ordinal = 0)
    private int code;
    @JSONField(name = "err", ordinal = 1)
    private int error;
    @JSONField(name = "msg", ordinal = 2)
    private String msg = "";
    @JSONField(name = "data", ordinal = 3)
    private Object data = new ArrayList<>();

    public ResultCode() {


    }

    public ResultCode(int code, int error, String msg, Object data) {
        this.code = code;
        this.error = error;
        if (null != msg) {
            this.msg = msg;
        }
        if (null != data) {
            this.data = data;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", error=" + error +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
