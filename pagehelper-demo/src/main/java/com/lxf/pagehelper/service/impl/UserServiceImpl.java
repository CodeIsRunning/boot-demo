package com.lxf.pagehelper.service.impl;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lxf.pagehelper.mapper.UserMapper;
import com.lxf.pagehelper.model.User;
import com.lxf.pagehelper.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

	@Override
	public PageInfo<User> selectAll(){

        PageHelper.startPage(1, 10);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectAll()) ;
		 return pageInfo;
	}




}
