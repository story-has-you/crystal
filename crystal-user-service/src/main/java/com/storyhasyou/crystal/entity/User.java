package com.storyhasyou.crystal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.storyhasyou.kratos.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fangxi created by 2022/6/20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`user`")
public class User extends BaseEntity {
    /**
     * 昵称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 用户签名
     */
    @TableField(value = "slogan")
    private String slogan;

    /**
     * 1.男, 2.女
     */
    @TableField(value = "gender")
    private Boolean gender;

    /**
     * 积分
     */
    @TableField(value = "points")
    private Integer points;

    /**
     * 邮箱
     */
    @TableField(value = "mail")
    private String mail;

    /**
     * 盐，用于个人敏感信息处理
     */
    @TableField(value = "secret")
    private String secret;
}