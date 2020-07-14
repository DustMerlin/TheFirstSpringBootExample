package com.Merlin.hello.controller;

import com.Merlin.hello.mapper.UserMapper;
import com.Merlin.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Created by conteoller on 2020.1.18

@Controller
public class HelloController {
    //访问时不能出现空格http://localhost:8080/hello?name = Merlin   错误
    //    http://localhost:8080/hello?name=Merlin                  正确
//    @GetMapping("/hello")
//    public String hello(@RequestParam(name = "name") String name, Model model){
//        model.addAttribute("name",name);
//        return "index";
//
//    }
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/index")
    public String hello(Model model){
        //ctrl alt v 自动生成变量定义
        //shift F6 批量修改全部选中的变量名
        //shift enter 从任意位直接换到下一行
        System.out.println("hello");
//        userMapper.insert(new User("95005",20,"SC","SM",'F'));
//
//        System.out.println("helloSuccess");
//        User user = new User();
//        user.setSno("95007");
//        user.setAname("SL");
//        user.setSsex('F');
//        user.setSage(20);
//        user.setAdept("SC");
//        userMapper.insert(user);
        return "index.html";

    }

}