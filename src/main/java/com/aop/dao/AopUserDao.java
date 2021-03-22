package com.aop.dao;

import com.aop.entity.AopUser;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
public interface AopUserDao {

    AopUser select(Integer id) throws Exception;

    void addUser(AopUser user) throws Exception;

    void update(AopUser user) throws Exception;

}
