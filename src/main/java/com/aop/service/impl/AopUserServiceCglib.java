package com.aop.service.impl;

import com.aop.dao.AopUserDao;
import com.aop.entity.AopUser;
import com.aop.service.AopUserService;
import org.springframework.stereotype.Service;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
@Service
public class AopUserServiceCglib {

    AopUserDao aopUserDao;

    public AopUser select(Integer id) throws Exception {
        System.out.println("查询操作");
        return aopUserDao.select(id);
    }

    public void addUser(AopUser user) throws Exception {
        System.out.println("增加操作");
        aopUserDao.addUser(user);
    }

    public void update(AopUser user) throws Exception {
        System.out.println("修改操作");
        aopUserDao.update(user);
    }
}
