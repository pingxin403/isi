package com.ujs.isi.utils;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.ujs.isi.commons.ResultCode;
import com.ujs.isi.dao.CommonsDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.commons
 * hyp create at 2019/5/25
 **/
public class ServicesUtils {
    private static CommonsDao dao = new CommonsDao();

    public static CommonsDao getDao() {
        return dao;
    }


    public static String ToJSON(ResultCode c) {

        return JSON.toJSONString(c);
    }

    public static ResultCode ToObject(String s) {
        JSONParser parser = new JSONParser(s);

        return JSON.parseObject(s, ResultCode.class);
    }


    public static List<Map<String, Object>> count(int i) {
        List<Map<String, Object>> l = new ArrayList<>();
        Map<String, Object> m = new HashMap<>();
        m.put("count", i);
        l.add(m);
        return l;
    }

    public static ResultCode error(String msg) {
        return code(0, 1, msg, null);
    }

    public static ResultCode code(int code, int error, String msg, Object data) {
        return new ResultCode(code, error, msg, data);
    }

    public static ResultCode ok(Object data) {
        return code(1, 0, "", data);
    }


}
