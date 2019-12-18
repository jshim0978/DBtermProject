package com.example.dbtermprojectspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(){
        return "hello";
    }

    @GetMapping("/errorPage")
    public String error(){
        return "error/error-page";
    }
}
