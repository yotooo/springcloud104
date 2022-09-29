package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/11 16:25
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.itheima.dao")
public class UserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }
}