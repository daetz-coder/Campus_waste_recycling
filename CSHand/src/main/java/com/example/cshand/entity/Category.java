package com.example.cshand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 类别表
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类名
     */
    private String name;

    /**
     * 父级ID
     */
    private String parentName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}