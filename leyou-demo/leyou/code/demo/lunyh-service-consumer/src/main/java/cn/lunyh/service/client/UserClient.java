package cn.lunyh.service.client;

import cn.lunyh.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-provider", fallback = UserClientFallback.class) // 标注该类是一个feign接口
//@RequestMapping("user") //ok的
public interface UserClient {
    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id") Long id);
}
