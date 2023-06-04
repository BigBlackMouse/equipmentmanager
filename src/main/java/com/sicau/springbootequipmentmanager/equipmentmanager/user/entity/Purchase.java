package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("purchase")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pur_id", type = IdType.AUTO)
    private Integer purId;

    @TableField("user_id")
    private String userId;

    @TableField("equ_name")
    private String equName;

    @TableField("pur_applyreason")
    private String purApplyreason;

    @TableField("pur_purchasenumber")
    private Integer purPurchasenumber;

    @TableField("pur_price")
    private Float purPrice;

    @TableField("pur_applydate")
    private LocalDate purApplydate;

    @TableField("adm_dealstatus")
    private String admDealstatus;

    @TableField("adm_reply")
    private String admReply;


}
