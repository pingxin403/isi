package com.ujs.isi.web;

import com.ujs.isi.commons.ISIException;
import com.ujs.isi.commons.ISIServlet;
import com.ujs.isi.utils.ServicesUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 获取设备
 *
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.web
 * hyp create at 2019/5/25
 **/
public class DeviceServlet extends ISIServlet {
    @Override
    public List code(HttpServletRequest request, HttpServletResponse response) throws ISIException {

        int f = Integer.parseInt(request.getParameter("from"));
        int t = Integer.parseInt(request.getParameter("to"));


        return ServicesUtils.getDao().getDevices(f, t);
    }
}
