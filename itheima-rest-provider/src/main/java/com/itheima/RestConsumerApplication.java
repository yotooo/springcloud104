package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/11 15:08
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
public class RestConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}