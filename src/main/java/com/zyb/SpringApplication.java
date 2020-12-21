package com.zyb;

import com.spring.SpringApplicationContext;
import com.zyb.service.OrderService;

/**
 * @author by ben
 * @Description TODO
 * @Date 2020/12/18
 */
public class SpringApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("test============");
        //启动Spring（扫描类，创建非懒加载的bean）
        SpringApplicationContext   springApplicationContext  =new SpringApplicationContext(AppConfig.class);
        //获取bean
        OrderService orderService = (OrderService) springApplicationContext.getBean("orderService");
        orderService.test();
        //获取注解扫描



    }
}
