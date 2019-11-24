package com.lxf.alipay;

import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePayRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPayResult;
import com.lxf.alipay.constans.Common;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.rmi.runtime.Log;

@Slf4j
@SpringBootTest
class AlipayDemoApplicationTests {

    @Test
    void contextLoads() {

        AlipayTradePayRequestBuilder builder = new AlipayTradePayRequestBuilder();
        builder.setOutTradeNo("4546816f46515"); // 定单号
        builder.setTotalAmount("10.00"); // 总金额
        builder.setAuthCode("283741387539674148"); // 授权码
        builder.setSubject("沙箱测试"); // 定单标题


        builder.setBody("沙箱测试");// 描述

        builder.setStoreId("测试");// 商家ID
        builder.setScene("bar_code");

        AlipayF2FPayResult result = Common.tradeService.tradePay(builder);

        log.info(result.getResponse().toString());

    }

}
