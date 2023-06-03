package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
@TableName("scraprecord")
public class ScrapRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "scr_id", type = IdType.AUTO)
    private Integer repId;

    @TableField("equ_id")
    private Integer equId;

    @TableField("adm_id")
    private Integer admId;

    @TableField("scr_reason")
    private String scrReason;

    @TableField("scr_date")
    private Date scrDate;
}
