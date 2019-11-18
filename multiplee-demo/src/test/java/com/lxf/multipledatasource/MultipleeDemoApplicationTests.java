package com.lxf.multipledatasource;

import com.lxf.multipledatasource.mapper1.UserMapper1;
import com.lxf.multipledatasource.mapper2.UserMapper2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.descriptor.Filterable;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class MultipleeDemoApplicationTests {

    /**
     * 数据源1
     */
    @Resource
    UserMapper1 userMapper1;

    /**
     * 数据源2
     */
    @Resource
    UserMapper2 userMapper2;

    @Test
    void contextLoads() {


        log.info("数据源1:"+userMapper1.selectByPrimaryKey(1L).toString());
        log.info("数据源2："+userMapper2.selectByPrimaryKey(2L).toString());

    }

}
