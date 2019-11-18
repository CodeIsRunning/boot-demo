package com.lxf.mybatis;

import com.lxf.mybatis.mapper.UserMapper;
import com.lxf.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {

       User user = userMapper.selectByPrimaryKey(2L);

        System.out.println(user);
    }

}
