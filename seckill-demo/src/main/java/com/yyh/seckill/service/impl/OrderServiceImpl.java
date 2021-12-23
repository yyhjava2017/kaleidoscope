package com.yyh.seckill.service.impl;

import com.yyh.seckill.pojo.Order;
import com.yyh.seckill.mapper.OrderMapper;
import com.yyh.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
