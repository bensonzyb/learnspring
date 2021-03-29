package com.aop.service.impl;

import com.aop.dao.AopUserDao;
import com.aop.entity.AopUser;
import com.aop.service.AopUserService;
import com.aop.util.LoggerOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
@Service
public class AopUserServiceImpl  implements AopUserService {

    @Autowired
    public  AopUserDao aopUserDao;

    @Override
    @LoggerOut
    public AopUser select(Integer id) throws Exception {
        System.out.println("查询操作");
        return aopUserDao.select(id);
    }

    @Override
    public void addUser(AopUser user) throws Exception {
        System.out.println("增加操作");
        aopUserDao.addUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE )
    public void update(AopUser user) throws Exception {
        System.out.println("修改操作");
        aopUserDao.update(user);
    }
}
