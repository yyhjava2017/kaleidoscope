package com.yyh.seckill.mapper;

import com.yyh.seckill.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyh.seckill.pojo.GoodsVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-23
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVO> getGoodList();
}
