package com.ujs.isi.device;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.utils
 * hyp create at 2019/5/26
 **/
public class DeviceUtils {
    private static Properties prop = new Properties();
    private static DeviceUtils instance = new DeviceUtils();

    private DeviceUtils() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("devices.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static DeviceUtils getInstance() {
        if (null == instance) {
            instance = new DeviceUtils();
        }
        return instance;
    }

    public String get(String s) {
        return (String) prop.get(s);
    }

}
