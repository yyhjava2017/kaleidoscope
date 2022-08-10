package com.yyh.seckill.controller;

import com.yyh.seckill.pojo.GoodsVO;
import com.yyh.seckill.pojo.User;
import com.yyh.seckill.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        model.addAttribute("goodList", goodsService.getGoodList());
        return "goodList";
    }

    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(@PathVariable String goodsId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVO goodsVO = goodsService.getDetailById(goodsId);
        Date startDate = goodsVO.getStartDate();
        Date endDate = goodsVO.getEndDate();
        Date nowDate = new Date();
        int seckillStatus = 0;
        if (nowDate.after(startDate)) {
            seckillStatus = 1;
        } else if (nowDate.after(endDate)) {
            seckillStatus = 2;
        }
        model.addAttribute("seckillStatus",seckillStatus);
        model.addAttribute("goods", goodsVO);
        return "goodsDetail";
    }
}
