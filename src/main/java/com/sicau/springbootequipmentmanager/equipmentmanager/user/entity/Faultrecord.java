package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

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
@TableName("faultrecord")
public class Faultrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fau_id", type = IdType.AUTO)
    private Integer fauId;

    @TableField("adm_id")
    private Integer admId;

    @TableField("equ_id")
    private Integer equId;

    @TableField("user_id")
    private Integer userId;

    @TableField("fau_occurdate")
    private Date fauOccurDate;

    @TableField("fau_occurposition")
    private String fauOccurPosition;

    @TableField("fau_detail")
    private String fauDetail;

    @TableField("fau_img")
    private String fauImg;

    @TableField("adm_answer")
    private String admAnswer;

    @TableLogic
    @TableField("adm_del")
    private Integer admDel;

    @TableField("user_del")
    private Integer userDel;

    @TableField("adm_message")
    private String admMessage;


}
