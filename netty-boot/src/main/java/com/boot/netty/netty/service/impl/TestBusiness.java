package com.boot.netty.netty.service.impl;

import com.boot.netty.netty.bin.Biz;
import com.boot.netty.netty.server.ChannelSupervise;
import com.boot.netty.netty.service.BaseBusinessCourse;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: netty-boot
 * @description:
 * @author: lxf
 * @create: 2019-11-21 11:34
 **/
@Biz("test")
@Slf4j
@Service
public class TestBusiness implements BaseBusinessCourse {


    @Override
    public void doBiz(ChannelHandlerContext context, String message) {

       context.writeAndFlush("testBusiness");

    }
}
