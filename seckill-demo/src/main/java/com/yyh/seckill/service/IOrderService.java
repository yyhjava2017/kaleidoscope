package com.yyh.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyh.seckill.pojo.GoodsVO;
import com.yyh.seckill.pojo.Order;
import com.yyh.seckill.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-23
 */
public interface IOrderService extends IService<Order> {

    Order seckill(GoodsVO goodsVO, User user);
}
