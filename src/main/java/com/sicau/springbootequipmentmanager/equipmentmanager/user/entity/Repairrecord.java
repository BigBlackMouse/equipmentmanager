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
@TableName("repairrecord")
public class Repairrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rep_id", type = IdType.AUTO)
    private Integer repId;

    @TableField("equ_id")
    private Integer equId;

    @TableField("adm_id")
    private Integer admId;

    @TableField("rep_reason")
    private String repReason;

    @TableField("rep_person")
    private String repPerson;

    @TableField("rep_cost")
    private Float repCost;

    @TableField("rep_date")
    private LocalDate repDate;

    @TableField("rep_result")
    private String repResult;


}
