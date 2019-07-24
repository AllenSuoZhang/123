package cn.lunyh.user.controller;

import cn.lunyh.user.pojo.User;
import cn.lunyh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "hello test!";
    }

    @GetMapping("{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id")Long id){
        return this.userService.queryById(id);
    }

    @GetMapping("list")
    public String usersAll(Model model){
        List<User> users = this.userService.selectAll();
        model.addAttribute("users", users);
        return "users";
    }
}
