package com.yyh.seckill.controller;

import com.yyh.seckill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "login";
        }
        model.addAttribute("user",user);
        return "goodList";
    }
}
