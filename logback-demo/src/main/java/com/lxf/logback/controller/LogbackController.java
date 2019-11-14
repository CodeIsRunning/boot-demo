package com.lxf.logback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: logback-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-11 12:08
 **/
@Slf4j
@RestController
public class LogbackController {
    @GetMapping("hello")
    public String logbackTest()throws Exception{
        log.info("hello");
        throw  new Exception("ssss");

    }
}
