package com.qindy.controller;

import com.qindy.entity.Msg;
import com.qindy.entity.User;
import com.qindy.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ibm on 2017/5/18.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}/user")
    public User getById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @RequestMapping("/all")
    public List<User> getAll(){
        return userService.findAll();
    }

    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

}
