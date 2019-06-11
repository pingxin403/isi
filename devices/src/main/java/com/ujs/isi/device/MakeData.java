package com.ujs.isi.device;

import cmcc.iot.onenet.javasdk.model.Data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
;
import java.util.Map;
import java.util.Random;



import org.json.*;

import java.util.*;

public class MakeData {
    public static String markPM10OrPM25()
    {
        String data=null;
        Random rand=new Random();
        int tem=rand.nextInt(5000);
        data=String.valueOf(tem/10);
        return data;
    }
    public static String markVOCOrCarbon()
    {
        String data=null;
        Random rand=new Random();
        int tem=rand.nextInt(10000);
        data=String.valueOf(tem/100);
        return data;
    }

}
