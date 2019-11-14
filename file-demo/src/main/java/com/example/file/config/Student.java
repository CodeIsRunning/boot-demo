package com.example.file.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: file-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-09 20:33
 **/
@Component//加上注释@Component，可以直接在其他地方使用@Autowired来创建其实列对象
@ConfigurationProperties(prefix = "user")//设置配置文件的前缀
@PropertySource("classpath:student.properties")//设置自定义文件的路径
public class Student {


    @Value("${student.name:DefaultValue}")
    private String name;

    private String pass;

    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", sex=" + sex +
                '}';
    }
}
