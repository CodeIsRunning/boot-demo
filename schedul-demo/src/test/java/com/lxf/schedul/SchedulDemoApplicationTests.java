package com.lxf.schedul;

import com.lxf.schedul.dto.QuartzBean;
import com.lxf.schedul.utils.SchedulerUtils;
import org.junit.jupiter.api.Test;
import org.quartz.Scheduler;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SchedulDemoApplicationTests {


    @Resource
    SchedulerUtils schedulerUtils;

    @Resource
    Scheduler scheduler;

    @Test
    void contextLoads() throws Exception{
        QuartzBean bean = new QuartzBean();
        bean.setCron("* * * * * ? *");
        bean.setJobClass("com.lxf.schedul.task.Task1");
        bean.setJobName("task");
        schedulerUtils.runTask(scheduler,bean);
    }

}
