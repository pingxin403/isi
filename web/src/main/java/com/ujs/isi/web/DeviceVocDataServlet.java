package com.ujs.isi.web;

import com.ujs.isi.commons.ISIException;
import com.ujs.isi.commons.ISIServlet;
import com.ujs.isi.utils.ServicesUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.web
 * hyp create at 2019/5/25
 **/
public class DeviceVocDataServlet extends ISIServlet {
    @Override
    public List code(HttpServletRequest request, HttpServletResponse response) throws ISIException {
        BigDecimal b = null;
        String did = request.getParameter("did");
        if (null != did) {
            b = new BigDecimal(did);
        }

        int f = Integer.parseInt(request.getParameter("from"));
        int t = Integer.parseInt(request.getParameter("to"));

        return ServicesUtils.getDao().getDevicesDataVoc(b, f, t);
    }
}
