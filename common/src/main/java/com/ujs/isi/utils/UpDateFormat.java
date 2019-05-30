package com.ujs.isi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.utils
 * hyp create at 2019/5/26
 **/
public class UpDateFormat {
    private static ThreadLocal<DateFormat> upFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        }
    };

    public static Date parse(String dateStr) throws ParseException {

        return upFormat.get().parse(dateStr);

    }


    public static String format(Date date) {

        return upFormat.get().format(date);

    }
}
