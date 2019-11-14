package com.lxf.schedul.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: schedul-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-13 10:08
 **/
@Slf4j
public class Task1 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info(LocalDateTime.now().toString());
    }
}
