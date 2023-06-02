package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("equipment")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "equ_id", type = IdType.AUTO)
    private Integer equId;

    @TableField("fac_id")
    private Integer facId;

    @TableField("equ_name")
    private String equName;

    @TableField("equ_type")
    private String equType;

    @TableField("equ_purchasedate")
    private LocalDate equPurchasedate;

    @TableField("equ_purchaser")
    private String equPurchaser;

    @TableField("equ_singleprice")
    private Float equSingleprice;

    @TableField("equ_unit")
    private String equUnit;

    @TableField("equ_spec")
    private String equSpec;

    @TableField("equ_total")
    private Integer equTotal;

    @TableField("equ_curr")
    private Integer equCurr;

    @TableField("equ_position")
    private String equPosition;

    @TableField("del")
    private Integer del;


}
