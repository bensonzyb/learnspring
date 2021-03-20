package com.ioc.config;

import com.ioc.entity.Mysql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/16
 *
 * 创建外部Bean
 */
@Configuration
@PropertySource("classpath:db.properties")
public class MysqlConfig {
    @Bean
    public Mysql getMysql(){
        Mysql mysql = new Mysql();
        mysql.setDriver("${db.driver}");
        mysql.setUrl("${db.url}");
        return  mysql;
    }
}
