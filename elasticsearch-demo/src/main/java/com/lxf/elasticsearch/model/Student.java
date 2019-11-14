package com.lxf.elasticsearch.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: elasticsearch-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-12 11:21
 **/
@Data
public class Student implements Serializable {

    private Integer id;

    private String name;

    private String pass;

    private String address;

    private LocalDateTime updateTime;

}
