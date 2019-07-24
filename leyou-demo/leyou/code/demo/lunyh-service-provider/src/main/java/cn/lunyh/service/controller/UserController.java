package cn.lunyh.service.controller;

import cn.lunyh.service.pojo.User;
import cn.lunyh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String test() {
        return "hello test!";
    }

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") Long id) {
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this.userService.queryById(id);
    }

//    @GetMapping("list")
//    public String usersAll(Model model) {
//        List<User> users = this.userService.selectAll();
//        model.addAttribute("users", users);
//        return "users";
//    }
}
