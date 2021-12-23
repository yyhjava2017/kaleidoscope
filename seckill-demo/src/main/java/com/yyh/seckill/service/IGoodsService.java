package com.yyh.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyh.seckill.pojo.Goods;
import com.yyh.seckill.pojo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-23
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVO> getGoodList();
}
