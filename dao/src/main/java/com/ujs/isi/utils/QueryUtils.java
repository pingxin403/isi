package com.ujs.isi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author hyp
 * Project name is ims
 * Include in com.ujs.ims.utils
 * hyp create at 2019/5/23
 **/
public class QueryUtils {
    public static QueryUtils instance = new QueryUtils();
    private static Logger log = LoggerFactory.getLogger(QueryUtils.class);
    private static Properties pro = null;

    private QueryUtils() {
        pro = new Properties();
        try {
            pro.load(this.getClass().getClassLoader().getResourceAsStream("query.properties"));
        } catch (IOException e) {
            log.error("not Find query.properties");
        }
    }

    public String get(String key) {
        return (String) pro.get(key);
    }


}
