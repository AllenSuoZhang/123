package cn.lunyh.service.controller;

import cn.lunyh.service.client.UserClient;
import cn.lunyh.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("consumer/user")
//@DefaultProperties(defaultFallback = "fallBackMethod") // 定义全局的熔断方法
public class UserController {
//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;// eureka客户端，可以获取到eureka中服务的信息

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    @HystrixCommand // 标记该方法需要熔断
    public User queryUserById(@RequestParam("id") Long id){
//        if(id == 1){
//            throw new RuntimeException("太忙了");
//        }
//        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        // 因为只有一个Service-provider。所以获取第一个实例
//        ServiceInstance serviceInstance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
//        String url = "http://service-provider/user/" + id;
//        return this.restTemplate.getForObject(url, String.class);
        return this.userClient.queryUserById(id);
    }

//    public String fallBackMethod(){
//        return "服务正忙，请稍后再试";
//    }
}
