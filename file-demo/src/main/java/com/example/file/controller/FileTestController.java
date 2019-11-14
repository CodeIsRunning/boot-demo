package com.example.file.controller;

import com.example.file.config.Student;
import com.example.file.test.BootFileRead;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: file-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-09 20:17
 **/
@RestController
public class FileTestController {


    @Resource
    Student student;

    @GetMapping("/getFile1")
    public void getFile1()throws Exception{
        BootFileRead.getFile1();
    }

    @GetMapping("/getFile2")
    public void getFile2()throws Exception{
        BootFileRead.getFile2();
    }


    @GetMapping("/getFile3")
    public void getFile3()throws Exception{
        BootFileRead.getFile3();
    }

    @GetMapping("/getFile4")
    public void getFile4()throws Exception{
        BootFileRead.getFile4();
    }


    @GetMapping("/getFile5")
    public void getFile5()throws Exception{
        BootFileRead.getFile5();
    }

    @GetMapping("/getFile6")
    public void getFile6()throws Exception{
        BootFileRead.getFile6();
    }

    @GetMapping("/getFile7")
    public void getFile7()throws Exception{
        BootFileRead.getFile6();
    }

    public void getStudent(){
        System.out.println(student);
    }

}
