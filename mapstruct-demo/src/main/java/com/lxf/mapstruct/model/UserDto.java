package com.lxf.mapstruct.model;

import lombok.Data;

/**
 * @program: mapstruct-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-18 16:03
 **/
@Data
public class UserDto {


    private Integer id;

    private String name;

    private String passWord;

    private String mail;

    private String address;

}
