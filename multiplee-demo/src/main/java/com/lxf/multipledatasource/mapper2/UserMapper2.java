package com.lxf.multipledatasource.mapper2;

import com.lxf.multipledatasource.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}