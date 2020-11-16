package com.kweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {
    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }

}
