package com.aop.dao.impl;

import com.aop.dao.AopUserDao;
import com.aop.entity.AopUser;
import org.springframework.stereotype.Repository;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
@Repository
public class AopUserDaoImpl  implements AopUserDao {
    @Override
    public AopUser select(Integer id) throws Exception {
        if(null == id){
            throw  new  Exception("ID 不能为空");
        }
        return null;
    }

    @Override
    public void addUser(AopUser user) throws Exception {
        if(null == user || user.getId()==null){
            throw  new  Exception("user 不能为空");
        }
    }

    @Override
    public void update(AopUser user) throws Exception {
        if(null == user){
            throw  new  Exception("user 不能为空");
        }
    }
}
