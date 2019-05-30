package com.ujs.isi.device;

import cmcc.iot.onenet.javasdk.api.datapoints.AddDatapointsApi;
import cmcc.iot.onenet.javasdk.api.datastreams.GetDatastreamApi;
import cmcc.iot.onenet.javasdk.model.Data;
import cmcc.iot.onenet.javasdk.model.Datapoints;
import cmcc.iot.onenet.javasdk.response.BasicResponse;
import cmcc.iot.onenet.javasdk.response.datastreams.DatastreamsResponse;
import com.ujs.isi.commons.DataType;
import com.ujs.isi.utils.UpDateFormat;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi
 * hyp create at 2019/5/27
 **/
public class UpData {

    private static String[] ids = null;
    private static String key = "";
    private static String dsidUptime = "";

    private static String dsidCo2 = "";
    private static String dsidVoc = "";
    private static String dsidPm25 = "";
    private static String dsidPm10 = "";
    private static ThreadPoolExecutor executor
            = new ThreadPoolExecutor(5, 20, 200, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(50));
    private static Logger log = LoggerFactory.getLogger(UpData.class);
    private static UpData instance = new UpData();

    private static String last_at = "";
    private static int value = 3;

    private UpData() {
        ids = DeviceUtils.getInstance().get("dev.ids").split(",");
        key = DeviceUtils.getInstance().get("api.key");
        dsidUptime = (String) DeviceUtils.getInstance().get("data.id.uptime");
        dsidCo2 = (String) DeviceUtils.getInstance().get("data.id.co2");
        dsidVoc = (String) DeviceUtils.getInstance().get("data.id.voc");
        dsidPm25 = (String) DeviceUtils.getInstance().get("data.id.pm25");
        dsidPm10 = (String) DeviceUtils.getInstance().get("data.id.pm10");
    }

    public static UpData getInstance() {
        if (null == instance) {
            instance = new UpData();
        }
        return instance;
    }

    public int uptime() throws InterruptedException {
        if (null != ids && ids.length > 0) {
            GetDatastreamApi api = new GetDatastreamApi(ids[0], dsidUptime, key);
            BasicResponse<DatastreamsResponse> response = api.executeApi();
            log.info("uptime:" + "\t " + response.json);
            JSONObject jsonObject = new JSONObject(response.json);
            JSONObject data = jsonObject.getJSONObject("data");
            String at = (String) data.get("update_at");
            if (null != at && !at.equals(last_at)) {
                value = (int) data.get("current_value");
                last_at = at;

            }
        } else {
            log.warn("设备为空");
        }
        return value;
    }

    public void up() {

        DataType[] values = DataType.values();
        if (null != ids && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {

                for (int j = 0; j < values.length; j++) {
                    UpTask task = new UpTask(ids[i], key, values[j]);
                    executor.execute(task);
                }
            }
        } else {
            log.info("无设备");
        }
    }


    class UpTask implements Runnable {
        private String id;
        private String key;
        private DataType type;

        public UpTask(String id, String key, DataType type) {
            this.id = id;
            this.key = key;
            this.type = type;
        }

        @Override
        public void run() {
            Map<String, List<Datapoints>> map
                    = new HashMap<>();

            switch (type) {

                case CO2:
                    upMakeData(map, dsidCo2, MakeData.markVOCOrCarbon());
                    break;
                case VOC:
                    upMakeData(map, dsidVoc, MakeData.markVOCOrCarbon());
                    break;
                case PM25:
                    upMakeData(map, dsidPm25, MakeData.markPM10OrPM25());
                    break;
                case PM10:
                    upMakeData(map, dsidPm10, MakeData.markPM10OrPM25());
                    break;
                default:
                    break;
            }
            if (null != map.get("datastreams")) {
                AddDatapointsApi api = new AddDatapointsApi(map, null, null, id, key);
                BasicResponse<Void> response = api.executeApi();
                log.info("updata:" + id + "\t " + response.json);
            } else {
                log.warn("数据类型错误");
            }
        }


        private void upMakeData(Map<String, List<Datapoints>> map, String dsid, String data) {
            List<Datapoints> list = new ArrayList<Datapoints>();
            List<Data> dl = new ArrayList<Data>();
            dl.add(new Data(UpDateFormat.format(new Date()), data));
            list.add(new Datapoints(dsid, dl));
            map.put("datastreams", list);
        }
    }


}
