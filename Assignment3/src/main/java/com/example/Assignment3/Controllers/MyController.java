package com.example.Assignment3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {

    @RequestMapping("/view")

    public String home () {
        return "index";
    }
}
