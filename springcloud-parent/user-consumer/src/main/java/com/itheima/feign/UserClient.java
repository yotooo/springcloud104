package com.itheima.feign;

//声明式feigh接口,用作替代resttemplate发送请求接受响应

import com.itheima.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-provider")
public interface UserClient {
    //实际是发送请求给微服务,获取数据
    @RequestMapping("user/find/{id}")
    //@PathVariable(name = "id")   id一定要写
    public User findById(@PathVariable(name = "id") Integer id);

}
