package com.example.cshand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 总金额
     */
    private BigDecimal total;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 交易单号
     */
    private String tradeNo;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 收货人地址
     */
    private String address;

    /**
     * 备注
     */
    private String comment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}