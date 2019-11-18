package com.lxf.websocket.controller;

import com.lxf.websocket.websocket.WebSocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: websocket-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-15 20:09
 **/
@RestController
public class WebSocketController {

    @Resource
    WebSocket webSocket;


    @GetMapping("sendMessage")
    public String sendMessage(String data)throws Exception{
        webSocket.GroupSending(data);
        return data+"发送成功";
    }

}
