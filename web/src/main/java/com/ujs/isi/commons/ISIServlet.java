package com.ujs.isi.commons;

import com.ujs.isi.utils.ServicesUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author hyp
 * Project name is isi
 * Include in ${PACKAGE_NAME}
 * hyp create at 2019/5/25
 **/
public abstract class ISIServlet extends HttpServlet implements MakeCode {
    protected ResultCode code = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        List weather = null;
        try {
            weather = code(request, response);
            if (null != weather) {
                code = ServicesUtils.code(1, 0, "", weather);
            } else {
                code = ServicesUtils.error("系统错误");
            }
        } catch (ISIException e) {
            code = ServicesUtils.error(e.getMessage());
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
