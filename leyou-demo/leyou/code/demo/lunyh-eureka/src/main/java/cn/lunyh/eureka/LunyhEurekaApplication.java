package cn.lunyh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 启动eureka服务器
public class LunyhEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunyhEurekaApplication.class, args);
    }

}
