package com.ujs.isi.web;

import com.ujs.isi.commons.ISIException;
import com.ujs.isi.commons.ISIServlet;
import com.ujs.isi.utils.ServicesUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 获取不同天气用水用电
 *
 * @author hyp
 * Project name is isi
 * Include in ${PACKAGE_NAME}
 * hyp create at 2019/5/25
 **/
public class UseWeatherServlet extends ISIServlet {


    @Override
    public List code(HttpServletRequest request, HttpServletResponse response) throws ISIException {
        return ServicesUtils.getDao().getUseWeather();
    }
}
