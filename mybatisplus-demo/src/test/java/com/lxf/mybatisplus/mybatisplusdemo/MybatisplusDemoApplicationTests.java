package com.lxf.mybatisplus.mybatisplusdemo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxf.mybatisplus.mybatisplusdemo.mapper.UserMapper;
import com.lxf.mybatisplus.mybatisplusdemo.model.User;
import com.lxf.mybatisplus.mybatisplusdemo.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class MybatisplusDemoApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {


        Page<User> page = new Page<>(1,10);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();


        Page<User> userPage = (Page<User>) userMapper.selectPage(page,queryWrapper);

        System.out.println(JSONObject.toJSON(userPage));



    }

}
