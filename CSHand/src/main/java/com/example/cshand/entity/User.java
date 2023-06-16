package com.example.cshand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 位置
     */
    private String position;

    /**
     * 权限(1表示管理员，0表示普通用户)
     */
    private Integer role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}