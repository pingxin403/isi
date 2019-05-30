package com.ujs.isi.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.commons
 * hyp create at 2019/5/25
 **/
public interface MakeCode {
    public List code(HttpServletRequest request, HttpServletResponse response)
            throws ISIException;
}
