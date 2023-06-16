package com.example.cshand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 联系人表
 * @TableName infomation
 */
@TableName(value ="infomation")
@Data
public class Infomation implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 主订单ID
     */
    private Integer productId;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer count;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}