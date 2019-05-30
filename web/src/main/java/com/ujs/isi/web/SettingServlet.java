package com.ujs.isi.web;

import cmcc.iot.onenet.javasdk.api.datapoints.AddDatapointsApi;
import cmcc.iot.onenet.javasdk.response.BasicResponse;
import com.ujs.isi.commons.ISIException;
import com.ujs.isi.commons.ResultCode;
import com.ujs.isi.utils.DeviceUtils;
import com.ujs.isi.utils.ServicesUtils;
import com.ujs.isi.utils.UpDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hyp
 * Project name is isi
 * Include in ${PACKAGE_NAME}
 * hyp create at 2019/5/25
 **/
public class SettingServlet extends HttpServlet {
    private Logger log = LoggerFactory.getLogger(SettingServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ResultCode code = null;

        int t = Integer.parseInt(request.getParameter("uptime"));
        String key = (String) DeviceUtils.getInstance().get("api.key");
        String dataId = (String) DeviceUtils.getInstance().get("data.id.uptime");
        if (t == 0 || null == key || null == dataId) {
            code = ServicesUtils.error("参数错误");
        } else {
            try {
                String data = "{\"" + dataId + "\":{\"" + UpDateFormat.format(new Date()) + "\":" + t + "}}";


                int count = ServicesUtils.getDao().countDevice();
                List<Map<String, Object>> devices = ServicesUtils.getDao().getDevices(0, count);

                if (null != devices) {
                    for (Map<String, Object> device : devices) {
                        BigDecimal id = (BigDecimal) device.get("id");
                        String did = id.toString();
                        AddDatapointsApi api = new AddDatapointsApi(null, data, 4,
                                did, key);
                        BasicResponse<Void> resp = api.executeApi();
                        log.info(did + "{errno:" + resp.errno + " error:" + resp.error + "}");
                    }
                    code = ServicesUtils.code(1, 0, "", null);
                } else {
                    code = ServicesUtils.code(1, 0, "无设备", null);

                }

            } catch (ISIException e) {
                code = ServicesUtils.error(e.getMessage());
            }
        }
        PrintWriter out = response.getWriter();
        out.println(ServicesUtils.ToJSON(code));
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
