package com.ujs.isi.utils;


import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hyp
 * Project name is Database
 * Include in com.hyp.jdbc.utils
 * hyp create at 2018/10/27
 **/
public class DBUtils {
    private static DruidDataSource ds = null;
    private static Logger log = LoggerFactory.getLogger(DBUtils.class);
    private static DBUtils Instance = new DBUtils();


    private DBUtils() {
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
            if (null != in) {
                properties.load(in);
            } else {
                log.error("DBUtils Init error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ds = new DruidDataSource();
        ds.configFromPropety(properties);
    }

    public static DBUtils getInstance() {
        if (null == Instance) {
            synchronized (DBUtils.class) {
                Instance = new DBUtils();
            }
        }
        return Instance;
    }

    /**
     * @return Connection
     * @throws SQLException
     * @Method: getConnection
     * @Description: 从数据源中获取数据库连接
     */
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }


}
