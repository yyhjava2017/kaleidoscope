package com.yyh.seckill.controller;

import com.yyh.seckill.pojo.User;
import com.yyh.seckill.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "login";
        }
        model.addAttribute("user",user);
        model.addAttribute("goodList",goodsService.getGoodList());
        return "goodList";
    }
}
