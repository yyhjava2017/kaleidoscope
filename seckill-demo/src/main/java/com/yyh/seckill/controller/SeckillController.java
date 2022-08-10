package com.yyh.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyh.seckill.pojo.*;
import com.yyh.seckill.service.IGoodsService;
import com.yyh.seckill.service.IOrderService;
import com.yyh.seckill.service.ISeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSeckill")
    public String seckill(String goodsId, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        //查看库存
        GoodsVO goodsVO = goodsService.getDetailById(goodsId);
        if(goodsVO.getStockCount()<1){
            model.addAttribute("errmsg", StatusCode.EMPTY_ERROR.getMessage());
            return "secKillFail";
        }
        //判断是否重复购买
        SeckillOrder serviceOne = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().
                eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(serviceOne!=null){
            model.addAttribute("errmsg", StatusCode.REBUY_ERROR.getMessage());
            return "secKillFail";
        }

        //秒杀（生成订单）
        Order order = orderService.seckill(goodsVO,user);
        model.addAttribute("order",order);
        model.addAttribute("goods",goodsVO);
        return "orderDetail";
    }
}
