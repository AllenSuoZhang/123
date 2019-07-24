package cn.lunyh.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.lunyh.service.mapper")
@EnableDiscoveryClient // 启动eureka客户端，@EnableEurekaClient
public class LunyhServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunyhServiceProviderApplication.class, args);
    }

}
