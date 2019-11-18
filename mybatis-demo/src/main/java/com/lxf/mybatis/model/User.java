package com.lxf.mybatis.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
    private Long id;

    private String email;

    private String passWord;

    private String userName;

    private static final long serialVersionUID = 1L;
}