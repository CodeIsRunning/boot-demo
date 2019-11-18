package com.lxf.mybatisplus.mybatisplusdemo.config;
import java.util.List;
import com.lxf.mybatisplus.mybatisplusdemo.model.User;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mybatisplus-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-20 10:23
 **/
@Configuration
public class MyBatisPlusConfig {


    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }




}
