package com.ujs.isi.web;

import com.ujs.isi.commons.DownJob;
import com.ujs.isi.utils.SchedulerUtil;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author hyp
 * Project name is isi
 * Include in ${PACKAGE_NAME}
 * hyp create at 2019/5/26
 **/

public class WebListener implements ServletContextListener {
    private static Scheduler scheduler = null;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        scheduler = SchedulerUtil.hadleCronTrigger("down", "isi", "down"
                , "isi", DownJob.class, "*/2 * * * * ? *");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (null != scheduler) {
            try {
                scheduler.shutdown();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }
}
