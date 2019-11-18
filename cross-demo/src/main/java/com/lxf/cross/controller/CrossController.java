package com.lxf.cross.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cross-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-18 20:52
 **/
@CrossOrigin(value = "*")
@RestController
public class CrossController {

    @GetMapping("hell")
    public String test(){
        return "hell0";
    }

}
