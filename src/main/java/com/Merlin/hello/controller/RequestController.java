package com.Merlin.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//处理请求的Controller
@RestController
public class RequestController {

    @RequestMapping("/helloworld")
    public String showHelloWorld(){
        return "HelloWorld!";
    }
}
