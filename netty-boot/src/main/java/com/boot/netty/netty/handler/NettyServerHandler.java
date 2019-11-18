package com.boot.netty.netty.handler;

import com.boot.netty.netty.common.Constans;
import com.boot.netty.netty.server.ChannelSupervise;
import com.boot.netty.netty.service.impl.TestBusiness;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: netty-boot
 * @description:
 * @author: lxf
 * @create: 2019-11-21 09:15
 **/
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel active......"+ctx.channel().id());
        ChannelSupervise.addChannel(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info(ctx.channel().id()+"退出");
        ChannelSupervise.removeChannel(ctx.channel());
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("服务器收到消息: {}", msg.toString());
        TestBusiness testBusiness = (TestBusiness) Constans.coursesTable.get("test");
        testBusiness.doBiz(ctx,"");
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}


