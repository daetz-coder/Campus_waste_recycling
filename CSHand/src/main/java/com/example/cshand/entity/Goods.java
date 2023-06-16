package com.example.cshand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品表
 * @TableName goods
 */
@TableName(value ="goods")
@Data
public class Goods implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 图片
     */
    private String imageUrl;

    /**
     * 介绍
     */
    private String description;

    /**
     * 类别ID
     */
    private Integer categoryId;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 库存
     */
    private Integer store;

    /**
     * 使用年限
     */
    private String usedYear;

    /**
     * 状态
     */
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}