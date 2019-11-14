package com.lxf.schedul.contorller;

import com.lxf.schedul.dto.QuartzBean;
import com.lxf.schedul.utils.SchedulerUtils;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: schedul-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-13 10:48
 **/
@RestController
public class SchedulController {

    @Resource
    SchedulerUtils schedulerUtils;

    @Resource
    Scheduler scheduler;


    @GetMapping("run")
    public void start()throws Exception{
        QuartzBean bean = new QuartzBean();
        bean.setCron("*/1 * * * * ?");
        bean.setJobClass("com.lxf.schedul.task.Task1");
        bean.setJobName("task");
        schedulerUtils.runTask(scheduler,bean);
    }

    @GetMapping("pause")
    public void pause()throws Exception{
        schedulerUtils.pauseScheduleJob(scheduler,"task");
    }

    @GetMapping("resume")
    public void resume()throws Exception{
        schedulerUtils.resume(scheduler,"task");
    }

}
