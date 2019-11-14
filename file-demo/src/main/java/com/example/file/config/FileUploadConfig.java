package com.example.file.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: file-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-11 20:05
 **/
@Configuration
public class FileUploadConfig implements WebMvcConfigurer {

    /*
     * 静态资源本地映射
     * img是虚拟路径
     * 映射到本地D盘javaspace下的tomcatpath下
     * 浏览器访问:localhost:8080/img/xxx文件
     * */

    /**
     * 本地静态资源映射
     * img 为本地资源映射的 虚拟路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:D:/image/");
    }
}
