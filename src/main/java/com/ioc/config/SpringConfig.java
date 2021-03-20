package com.ioc.config;

import com.ioc.entity.OutEntity;
import com.ioc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/14
 */

@Configuration
@ComponentScan(basePackages = "com.zyb")
//@Import({MysqlConfig.class,myImportSelector.class,MyImportBeanDefinitionRegistrar.class})
@Import({MysqlConfig.class,MyImportBeanDefinitionRegistrar.class})
public class SpringConfig {

    @Bean(value = "user")
    public User getUser(OutEntity outEntity){
        User user =new User();
        user.setName("zyb");
        user.setAddr("广州白云区");
        System.out.println("outEntity:"+outEntity.getOutName());
        return  user;
    }



}
