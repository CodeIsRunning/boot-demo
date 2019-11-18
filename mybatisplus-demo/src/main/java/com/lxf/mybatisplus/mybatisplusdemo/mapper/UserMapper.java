package com.lxf.mybatisplus.mybatisplusdemo.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxf.mybatisplus.mybatisplusdemo.model.UserDto;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxf.mybatisplus.mybatisplusdemo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> selectAllById(Long id);

    List<User> selectAllByEmail(@Param("email")String email);



	List<UserDto> selectAllByEmail(Page page, @Param("email")String email);





}