package com.lxf.schedul.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: schedul-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-13 10:08
 **/
@Slf4j
@Component
public class Task2  {


    @Scheduled(cron = "*/1 * * * * ?")
    public void task()   {
       // log.info("注解。。。"+LocalDateTime.now());
    }
}
