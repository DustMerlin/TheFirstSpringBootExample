package com.Merlin.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Created by conteoller on 2020.1.18

@Controller
public class HelloController {
    //访问时不能出现空格http://localhost:8080/hello?name = Merlin   错误
    //    http://localhost:8080/hello?name=Merlin                  正确
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name",name);
        return "index";

    }

}