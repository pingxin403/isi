package com.ujs.isi.web;

import com.ujs.isi.commons.ISIException;
import com.ujs.isi.commons.ISIServlet;
import com.ujs.isi.utils.ServicesUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * 返回设备数据数量
 *
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.web
 * hyp create at 2019/5/25
 **/
public class CountDeviceCo2DataServlet extends ISIServlet {

    @Override
    public List code(HttpServletRequest request, HttpServletResponse response) throws ISIException {

        BigDecimal b = null;
        String did = request.getParameter("did");
        if (null != did) {
            b = new BigDecimal(did);
        }

        return ServicesUtils.count(ServicesUtils.getDao().countDeviceDataCo2(b));
    }
}
