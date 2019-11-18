package com.lxf.jpa;

import com.lxf.jpa.entity.User;
import com.lxf.jpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JpaDemoApplicationTests {

    @Resource
    UserRepository userRepository;

    @Test
    void contextLoads() {

        User user = new User();
        user.setUserName("test");
        user.setEmail("***.@.com");
        user.setPassWord("test");
        userRepository.save(user);

    }

}
