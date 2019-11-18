package com.lxf.mapstruct;

import com.lxf.mapstruct.mapper.UserMapper;
import com.lxf.mapstruct.model.Student;
import com.lxf.mapstruct.model.User;
import com.lxf.mapstruct.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class MapstructDemoApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {

        User user = new User();
        user.setId(1);
        user.setName("t1");
        user.setPass("p1");

        UserDto userDto = new UserDto();
        userDto.setId(2);
        userDto.setName("t2");
        userDto.setPassWord("p2");
        userDto.setAddress("11");
        userDto.setMail("@163.com");

       /* UserDto userDtoRes = userMapper.getUserDto(user);
        log.info(userDtoRes.toString());

        User userRes = userMapper.getUser(userDto);
        log.info(userRes.toString());*/

        User userRes =  userMapper.getUserV2(userDto);
        log.info(userRes.toString());

       Student student =  userMapper.getStudent(user,userDto);

       log.info(student.toString());
    }

}
