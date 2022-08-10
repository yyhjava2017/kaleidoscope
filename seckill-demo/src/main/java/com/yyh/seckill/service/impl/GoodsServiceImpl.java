package com.yyh.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyh.seckill.mapper.GoodsMapper;
import com.yyh.seckill.mapper.OrderMapper;
import com.yyh.seckill.pojo.Goods;
import com.yyh.seckill.pojo.GoodsVO;
import com.yyh.seckill.pojo.Order;
import com.yyh.seckill.service.IGoodsService;
import com.yyh.seckill.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-23
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public GoodsVO getDetailById(String goodsId) {
        return goodsMapper.getDetailById(goodsId);
    }

    @Override
    public List<GoodsVO> getGoodList() {
        return goodsMapper.getGoodList();
    }
}
