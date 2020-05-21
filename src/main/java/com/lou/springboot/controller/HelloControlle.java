package com.lou.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControlle {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello,shiyanlou";
    }
}
