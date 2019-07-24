package cn.lunyh.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient // 开启Eureka客户端
//@EnableCircuitBreaker // 开启熔断
@SpringCloudApplication // 组合注解来代替之前的3个注解。
@EnableFeignClients // 开启feign客户端
public class LunyhServiceConsumerApplication {

//    @Bean
//    @LoadBalanced // 开启负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(LunyhServiceConsumerApplication.class, args);
    }

}
