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
 * @TableName cart
 */
@TableName(value ="cart")
@Data
public class Cart implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 图片
     */
    private String imageUrl;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单价
     */
    private BigDecimal price;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}