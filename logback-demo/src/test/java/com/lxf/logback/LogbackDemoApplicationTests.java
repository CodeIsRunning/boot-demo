package com.lxf.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class LogbackDemoApplicationTests {

    Marker marker = MarkerFactory.getMarker("DB");

    @Test
    void contextLoads() {

        log.info(marker,"我是测试数据");
    }

}
