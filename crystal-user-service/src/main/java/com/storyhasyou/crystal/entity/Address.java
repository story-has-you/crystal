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
@TableName(value = "address")
public class Address extends BaseEntity {
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    @TableField(value = "default_status")
    private Integer defaultStatus;

    /**
     * 收发货人姓名
     */
    @TableField(value = "receive_name")
    private String receiveName;

    /**
     * 收货人电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 省/直辖市
     */
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区
     */
    @TableField(value = "region")
    private String region;

    /**
     * 详细地址
     */
    @TableField(value = "detail_address")
    private String detailAddress;
}