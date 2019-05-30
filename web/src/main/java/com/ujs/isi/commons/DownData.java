package com.ujs.isi.commons;

import cmcc.iot.onenet.javasdk.api.datapoints.GetDatapointsListApi;
import cmcc.iot.onenet.javasdk.response.BasicResponse;
import cmcc.iot.onenet.javasdk.response.datapoints.DatapointsList;
import com.ujs.isi.bean.TbCo2Data;
import com.ujs.isi.bean.TbPm10Data;
import com.ujs.isi.bean.TbPm25Data;
import com.ujs.isi.bean.TbVocData;
import com.ujs.isi.utils.DeviceUtils;
import com.ujs.isi.utils.DownDateFormat;
import com.ujs.isi.utils.ServicesUtils;
import com.ujs.isi.utils.UpDateFormat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.commons
 * hyp create at 2019/5/26
 **/
public class DownData {

    private static ThreadPoolExecutor executor
            = new ThreadPoolExecutor(20, 100, 200, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(300));
    private static Logger log = LoggerFactory.getLogger(DownData.class);
    private static String co2Id = (String) DeviceUtils.getInstance().get("data.id.co2");
    private static String vocId = (String) DeviceUtils.getInstance().get("data.id.voc");
    private static String pm10Id = (String) DeviceUtils.getInstance().get("data.id.pm10");
    private static String pm25Id = (String) DeviceUtils.getInstance().get("data.id.pm25");


    private static DataType[] types = DataType.values();


    public static void down() {
        try {
            List<Map<String, Object>> devices = ServicesUtils.getDao().getDevices(
                    0, ServicesUtils.getDao().countDevice());
            String key = (String) DeviceUtils.getInstance().get("api.key");

            if (null != devices && devices.size() != 0) {
                for (int i = 0; i < devices.size(); i++) {
                    Map<String, Object> map = devices.get(i);
                    BigDecimal id = (BigDecimal) map.get("id");
                    for (int j = 0; j < types.length; j++) {
                        DownTask task = new DownTask(id, key, types[j]);
                        executor.execute(task);
                        log.info("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                                executor.getQueue().size() + "，已执行的任务数目：" + executor.getCompletedTaskCount());
                    }

                }
            }

        } catch (ISIException e) {
            log.error("下载数据失败", e);
        }
    }


    static class DownTask implements Runnable {
        BigDecimal id;
        String key;
        DataType type;

        public DownTask(BigDecimal id, String key, DataType j) {
            this.id = id;
            this.key = key;
            this.type = j;
        }

        @Override
        public void run() {
            try {
                switch (type) {
                    case CO2:
                        downCo2();
                        break;
                    case VOC:
                        downVoc();
                        break;
                    case PM10:
                        downPm10();
                        break;
                    case PM25:
                        downPm25();
                        break;
                    default:
                        break;
                }


            } catch (ISIException | ParseException e) {
                e.printStackTrace();
            }

        }


        private void downCo2() throws ISIException, ParseException {
            List co2 = down(co2Id, ServicesUtils.getDao().getDevicesDataCo2(id, 0, 1));
            if (null != co2 && co2.size() > 0) {
                for (int i = 0; i < co2.size(); i++) {
                    Map<String, Object> map = (Map<String, Object>) co2.get(i);

                    Double value = Double.valueOf((String) map.get("value"));
                    Date date = DownDateFormat.parse((String) map.get("date"));

                    ServicesUtils.getDao().addDeviceDataCo2(new TbCo2Data(
                            id, value,
                            new Timestamp(date.getTime())
                    ));
                }
            }
        }

        private void downVoc() throws ISIException, ParseException {
            List voc = down(vocId, ServicesUtils.getDao().getDevicesDataVoc(id, 0, 1));
            if (null != voc && voc.size() > 0) {
                for (int i = 0; i < voc.size(); i++) {
                    Map<String, Object> map = (Map<String, Object>) voc.get(i);
                    Double value = Double.valueOf((String) map.get("value"));
                    Date date = DownDateFormat.parse((String) map.get("date"));

                    ServicesUtils.getDao().addDeviceDataVoc(new TbVocData(
                            id, value,
                            new Timestamp(date.getTime())
                    ));
                }
            }
        }

        private void downPm25() throws ISIException, ParseException {
            List pm25 = down(pm25Id, ServicesUtils.getDao().getDevicesDataPM25(id, 0, 1));
            if (null != pm25 && pm25.size() > 0) {
                for (int i = 0; i < pm25.size(); i++) {
                    Map<String, Object> map = (Map<String, Object>) pm25.get(i);

                    Double value = Double.valueOf((String) map.get("value"));
                    Date date = DownDateFormat.parse((String) map.get("date"));

                    ServicesUtils.getDao().addDeviceDataPM25(new TbPm25Data(
                            id, value,
                            new Timestamp(date.getTime())
                    ));
                }
            }
        }

        private void downPm10() throws ISIException, ParseException {
            List pm10 = down(pm10Id, ServicesUtils.getDao().getDevicesDataPM10(id, 0, 1));
            if (pm10 != null && pm10.size() > 0) {
                for (int i = 0; i < pm10.size(); i++) {
                    Map<String, Object> map = (Map<String, Object>) pm10.get(i);

                    Double value = Double.valueOf((String) map.get("value"));

                    Date date = DownDateFormat.parse((String) map.get("date"));
                    ServicesUtils.getDao().addDeviceDataPM10(new TbPm10Data(
                            id, value,
                            new Timestamp(date.getTime())
                    ));
                }
            }
        }


        private List down(String ID, List<Map<String, Object>> data) {
            List list = null;
            log.info(data.toString());
            try {

                GetDatapointsListApi api = null;
                Date d = new Date();
                Timestamp t = null;
                if (null != data && data.size() > 0) {
                    Map<String, Object> map = data.get(0);
                    Date date = DownDateFormat.parse((String) map.get("date"));
                    t = new Timestamp(date.getTime() + 1000);

                } else {

                    t = new Timestamp(DownDateFormat.parse("2000-01-01 00:00:00").getTime());
                }


                log.info(t.toString());
                log.info(String.valueOf((d.getTime() - t.getTime())));
                api = new GetDatapointsListApi(ID, UpDateFormat.format(t), UpDateFormat.format(d), id.toString(),
                        null, null, null, null,
                        null, null, null, key);

                BasicResponse<DatapointsList> response = api.executeApi();
                if (response.errno == 0) {
                    log.info(response.getJson());
                    list = jsonToList(response.getJson());


                } else {
                    log.error(id + "{errno:" + response.errno + " error:" + response.error + "}");
                }

            } catch (ParseException e) {
                log.error("获取数据失败", e);
            }
            return list;

        }

        private List jsonToList(String json) throws ParseException {

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            JSONObject jsonObject = new JSONObject(json);
            JSONObject d = jsonObject.getJSONObject("data");
            JSONArray datastreams = d.getJSONArray("datastreams");
            if (datastreams.length() > 0) {
                JSONObject da = datastreams.getJSONObject(0);
                JSONArray datapoints = da.getJSONArray("datapoints");
                int length = d.getInt("count");

                for (int j = 0; j < length; j++) {
                    Map<String, Object> map = new HashMap<>();
                    JSONObject jsonObject1 = datapoints.getJSONObject(j);
                    map.put("date", jsonObject1.get("at"));
                    map.put("value", jsonObject1.get("value"));
                    list.add(map);
                }
            }

            return list;

        }

    }


}
