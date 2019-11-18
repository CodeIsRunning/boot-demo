package com.lxf.war.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: war-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-18 20:07
 **/
@RestController
public class TestController {

    @GetMapping("hello")
    public String getString(){
        return "test";
    }

}
