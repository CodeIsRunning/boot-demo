package com.lxf.websocket.websocket;




import com.lxf.websocket.controller.Test;
import lombok.extern.slf4j.Slf4j;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocket {

    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    private static Test test;

    @Autowired
    public void setTest(Test test){
        WebSocket.test =test;
    }

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String, WebSocket> webSocketSet = new ConcurrentHashMap<>();


    public static ConcurrentHashMap<String, WebSocket> getWebSocketSet() {
        return webSocketSet;
    }

    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name) {
        this.session = session;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketSet.put(name, this);

        AppointSending(name, "连接成功");

        log.info(name + "连接成功，当前连接人数为：={}", webSocketSet.size());
    }


    @OnClose
    public void OnClose(Session session, @PathParam(value = "name") String name) {
        webSocketSet.remove(name);
        log.info(name + " 退出成功，当前连接人数为：={}", webSocketSet.size());
    }

    @OnMessage
    public void OnMessage(String message) {
        log.info("[WebSocket] 收到消息：{}", message);

    }

    /**
     * 群发
     *
     * @param message
     */
    public void GroupSending(String message) throws Exception {
        for (String name : webSocketSet.keySet()) {

            webSocketSet.get(name).session.getBasicRemote().sendText(message);

        }
    }

    /**
     * 指定发送
     *
     * @param name
     * @param message
     */
    public void AppointSending(String name, String message) {
        try {
            if (webSocketSet.containsKey(name)) {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            }

        } catch (Exception e) {
            log.info(ExceptionUtils.getMessage(e));
            e.printStackTrace();
        }

    }

}
