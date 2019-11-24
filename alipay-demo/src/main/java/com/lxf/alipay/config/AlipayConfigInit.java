package com.lxf.alipay.config;

import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.lxf.alipay.constans.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlipayConfigInit implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(AlipayConfigInit.class);


	private AlipayTradeServiceImpl.ClientBuilder builder = new AlipayTradeServiceImpl.ClientBuilder();

	@Override
	public void run(String... arg0) throws Exception {

		log.info("支付宝初始化开始");
		Configs.init("zfbinfo.properties");
		Common.tradeService = builder.build();
		log.info("支付宝初始化结束");
	}

}
