package com.example.cshand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    /**
     * 订单表
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品小计
     */
    private BigDecimal subtotal;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}