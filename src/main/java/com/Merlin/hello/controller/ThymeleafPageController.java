package com.Merlin.hello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
   ThymeleafPageController
 */
@Controller
public class ThymeleafPageController {

    @GetMapping("/index.html")
    public String showPage(Model model){
        model.addAttribute("msg","Hello ThymeleafPageController");
        return "index";
    }
}
