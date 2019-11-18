package com.lxf.mybatisplus.mybatisplusdemo.model;

import lombok.Data;

/**
 * @program: mybatisplus-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-20 10:54
 **/
@Data
public class UserDto extends User{

    private String name;
    private String teacher;


}
