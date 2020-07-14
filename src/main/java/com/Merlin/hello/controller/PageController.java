package com.Merlin.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    //GetMapping和RequestMapping  有什么区别
    @RequestMapping("/page")
    public String showPage(){
        System.out.println("this is sb");
        //此处可能直接定位到templates 文件夹，所以需要相对路径找到对应的static 切记！！！
        return "../static/sb.html";
    }
}
