package com.lxf.pagehelper.controller;

import com.lxf.pagehelper.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: pagehelper-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-13 19:10
 **/
@RestController
public class PageHelperController {

    @Resource
    UserService userService;

    @GetMapping("getPageList")
   public Object getPagelist(){
       return userService.selectAll();
    }

}
