package com.lxf.pagehelper.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lxf.pagehelper.model.User;
public interface UserService{


    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);



    PageInfo<User> selectAll();


}
