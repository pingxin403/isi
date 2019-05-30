package com.ujs.isi.commons;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.commons
 * hyp create at 2019/5/26
 **/
public class DownJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DownData.down();
    }
}
