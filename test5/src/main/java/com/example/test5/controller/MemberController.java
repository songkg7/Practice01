package com.example.test5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/")
    public String loginForm() {
        return "loginForm";
    }
}