package com.boot.netty.netty.common;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import javafx.collections.SetChangeListener;
import org.springframework.util.CollectionUtils;

import java.io.BufferedWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: netty-boot
 * @description:
 * @author: lxf
 * @create: 2019-11-21 10:59
 **/
public class Constans {

    private   static ChannelGroup GlobalGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 业务service 集合
     */
    public  static  Map<String, Object> coursesTable = new ConcurrentHashMap<>();

    /**
     * 商户连接分组
     */
    private  static Map<String, ChannelGroup> businessGroup = new ConcurrentHashMap<>();

    public static ChannelGroup getGlobalGroup(String id){
        return  businessGroup.get("id");
    }

    public static void setGlobalGroup(String id, Channel channel){
        if (CollectionUtils.isEmpty(businessGroup.get(id))){
             ChannelGroup GlobalGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
             GlobalGroup.add(channel);
             businessGroup.put(id,GlobalGroup);
        }else {
            businessGroup.get(id).add(channel);
        }
    }

}
