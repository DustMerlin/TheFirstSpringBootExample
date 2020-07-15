package com.Merlin.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*
    JSP页面跳转Controller
 */

//页面跳转，需要视图解析器
@Controller
public class JspPageController {
//    页面跳转

    @GetMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
