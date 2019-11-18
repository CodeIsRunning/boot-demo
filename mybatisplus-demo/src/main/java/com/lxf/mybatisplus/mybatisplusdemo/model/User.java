package com.lxf.mybatisplus.mybatisplusdemo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "user")
public class User implements Serializable {
     @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "email")
    private String email;

    @TableField(value = "nick_name")
    private String nickName;

    @TableField(value = "pass_word")
    private String passWord;

    @TableField(value = "reg_time")
    private String regTime;

    @TableField(value = "user_name")
    private String userName;

    private static final long serialVersionUID = 1L;

    public static final String COL_EMAIL = "email";

    public static final String COL_NICK_NAME = "nick_name";

    public static final String COL_PASS_WORD = "pass_word";

    public static final String COL_REG_TIME = "reg_time";

    public static final String COL_USER_NAME = "user_name";
}