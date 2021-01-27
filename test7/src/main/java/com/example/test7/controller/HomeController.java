package com.example.test7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // FIXME: 홈페이지 기능 실행 안됨!
    @GetMapping("/")
    public String home() {
        return "login";
    }
}
