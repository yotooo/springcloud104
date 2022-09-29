package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/11 15:08
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User findById(@PathVariable(name = "id") Integer id) {
        //使用restTemplate模拟浏览器发送请求获取远程微服务【provider】的用户的信息
        User userFromProvider = restTemplate.getForObject("http://localhost:8001/user/" + id, User.class);
        //返回前端查看
        return userFromProvider;
    }
}