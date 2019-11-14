package com.lxf.elasticsearch.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @program: elasticsearch-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-12 11:05
 **/
@Slf4j
@Configuration
public class EsConfig {
    /**
     * 集群地址，多个用,隔开
     */
    private static String hosts = "127.0.0.1:9200";


    @Bean(value = "restHighLevelClient")
    public RestHighLevelClient initEsClient() {

        log.info("es初始化:" + hosts);

        try {
            String[] clusterNodeArray = hosts.split(",");
            int hostNum = clusterNodeArray.length;
            HttpHost[] hostArray = new HttpHost[hostNum];
            for (int index = 0; index < hostNum; index++) {
                String clusterNode = clusterNodeArray[index];
                String[] hostIpPort = clusterNode.split(":");
                hostArray[index] = new HttpHost(hostIpPort[0], Integer.valueOf(hostIpPort[1]), "http");
            }
            RestClientBuilder restClient = RestClient.builder(hostArray);
            return new RestHighLevelClient(restClient);
        } catch (Exception e) {
            log.info("es初始化异常" + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }
}
