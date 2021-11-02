package com.example.assignment1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping({
            "main.html",
            "main",
            "/"
    })
    public String main()
    {
        return "main";
    }
}
