package com.boot.netty.netty.bin;

import java.lang.annotation.*;

/**
 * @author lxf
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Biz {

    /**
     * 业务编号
     * @return
     */
    String value();

}