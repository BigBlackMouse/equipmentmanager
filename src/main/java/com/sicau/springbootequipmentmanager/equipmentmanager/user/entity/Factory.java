package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("factory")
public class Factory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fac_id", type = IdType.AUTO)
    private Integer facId;

    @TableField("fac_name")
    private String facName;

    @TableField("fac_addr")
    private String facAddr;

    @TableField("fac_phone")
    private String facPhone;


}
