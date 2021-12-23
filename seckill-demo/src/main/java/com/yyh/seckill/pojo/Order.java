package com.yyh.seckill.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yyhAuto
 * @since 2021-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 地址id
     */
    private Long addressId;

    /**
     * 订单来源
     */
    private Integer orderChannel;

    /**
     * 商品价格
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 商品价格
     */
    private Date payDate;


}
