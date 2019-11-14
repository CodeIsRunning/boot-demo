package com.lxf.schedul.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: schedul-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-13 11:19
 **/
@Data
public class QuartzBean {


    /** 任务名称 */
    private String jobName;

    /** 任务执行类 */
    private String jobClass;

    /** 任务运行时间表达式 */
    private String cron;
}
