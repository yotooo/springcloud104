package com.itheima.controller;

import com.itheima.domain.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/11 16:38
 * @description 标题
 * @package com.itheima.controller
 */
@RestController
@RequestMapping(value = "/consumer")
@DefaultProperties(defaultFallback = "defaultFallbackMy")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    /****
     * 在user-consumer服务中通过RestTemplate调用user-provider服务
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
//    @HystrixCommand(fallbackMethod = "findDefault")
    @HystrixCommand
    public User findById(@PathVariable(value = "id") Integer id) {
        //动态获取服务名
//        List<ServiceInstance> instances = discoveryClient.getInstances("USER-PROVIDER");
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/" + id;
        User user = restTemplate.getForObject("http://USER-PROVIDER/user/"+id, User.class);
        return user;
    }

//    public User findDefault(Integer id){
//        User user = new User();
//        user.setId(1);
//        user.setName("匿名用户");
//        return user;
//    }
    public User defaultFallbackMy(){
        User user = new User();
        user.setId(1);
        user.setName("匿名用户-全局");
        return user;
    }

}