package com.lxf.schedul.utils;

import com.lxf.schedul.dto.QuartzBean;
import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * @program: schedul-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-13 11:18
 **/
@Component
public class SchedulerUtils {

    /**
     * 构建定时任务
     * @param scheduler
     * @param quartzBean
     * @throws Exception
     */
    public void runTask(Scheduler scheduler, QuartzBean quartzBean)throws Exception{

        //任务类
        Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(quartzBean.getJobClass());
        // 定时任务信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(quartzBean.getJobName()).build();
        // 执行表达式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCron());
        // 触发器trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzBean.getJobName()).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 根据任务名称暂停定时任务
     * @param scheduler  调度器
     * @param jobName    定时任务名称
     * @throws Exception
     */
    public  void pauseScheduleJob(Scheduler scheduler, String jobName) throws Exception{
        JobKey jobKey = JobKey.jobKey(jobName);

            scheduler.pauseJob(jobKey);

    }

    /**
     * 根据任务名称恢复定时任务
     * @param scheduler  调度器
     * @param jobName    定时任务名称
     * @throws Exception
     */
    public  void resume(Scheduler scheduler, String jobName) throws Exception{
        JobKey jobKey = JobKey.jobKey(jobName);

            scheduler.resumeJob(jobKey);

    }

    /**
     * 根据任务名称立即运行一次定时任务
     * @param scheduler     调度器
     * @param jobName       定时任务名称
     * @throws Exception
     */
    public  void runOnce(Scheduler scheduler, String jobName)throws Exception{
        JobKey jobKey = JobKey.jobKey(jobName);

            scheduler.triggerJob(jobKey);

    }

    /**
     * 根据定时任务名称从调度器当中删除定时任务
     * @param scheduler 调度器
     * @param jobName   定时任务名称
     * @throws Exception
     */
    public  void deleteScheduleJob(Scheduler scheduler, String jobName)throws Exception{
        JobKey jobKey = JobKey.jobKey(jobName);

            scheduler.deleteJob(jobKey);

    }


    /**
     * 更新定时任务
     * @param scheduler   调度器
     * @param quartzBean  定时任务信息类
     * @throws Exception
     */
    public  void updateScheduleJob(Scheduler scheduler, QuartzBean quartzBean) throws Exception {

            //获取到对应任务的触发器
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzBean.getJobName());
            //设置定时任务执行方式
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCron());
            //重新构建任务的触发器trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            //重置对应的job
            scheduler.rescheduleJob(triggerKey, trigger);

    }

}
