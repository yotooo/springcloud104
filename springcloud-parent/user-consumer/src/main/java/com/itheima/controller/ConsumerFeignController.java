package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class ConsumerFeignController {
    @Autowired
    UserClient userClient;



    //根据id获取用户的数据
    @RequestMapping("/{id}")
    public User queryById(@PathVariable("id") Integer id){
        User user = userClient.findById(id);
        return user;
    }
}
