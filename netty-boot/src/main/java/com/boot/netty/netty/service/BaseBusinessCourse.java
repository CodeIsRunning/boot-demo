package com.boot.netty.netty.service;



import io.netty.channel.ChannelHandlerContext;

public interface BaseBusinessCourse {
	public void doBiz(ChannelHandlerContext context, String message);
}
