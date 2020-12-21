package com.zyb.service;

import com.spring.Autowired;
import com.spring.Component;
import com.spring.Scope;

/**
 * @author by ben
 * @Description TODO
 * @Date 2020/12/18
 */
@Component("orderService")
public class OrderService {

    @Autowired
    private  UserService userService;

    public  void test(){
        System.out.println(userService);
    }
}
