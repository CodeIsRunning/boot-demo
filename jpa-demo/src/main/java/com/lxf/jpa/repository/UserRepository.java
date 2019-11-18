package com.lxf.jpa.repository;

import com.lxf.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: jpa-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-24 19:38
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);

}
