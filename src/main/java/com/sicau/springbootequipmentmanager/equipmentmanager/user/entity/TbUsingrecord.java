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
@TableName("tb_usingrecord")
public class TbUsingrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "usi_id", type = IdType.AUTO)
    private Integer usiId;

    @TableField("user_id")
    private String userId;

    @TableField("equ_id")
    private Integer equId;

    @TableField("adm_id")
    private String admId;

    @TableField("usi_reason")
    private String usiReason;

    @TableField("usi_number")
    private Integer usiNumber;

    @TableField("usi_date")
    private LocalDate usiDate;

    @TableField("usi_returndate")
    private LocalDate usiReturndate;

    @TableField("usi_applystatus")
    private String usiApplystatus;

    @TableField("adm_feedbackapply")
    private String admFeedbackapply;

    @TableField("usi_returnstatus")
    private String usiReturnstatus;

    @TableField("adm_feedbackreturn")
    private String admFeedbackreturn;

    @TableField("user_del")
    private Integer userDel;

    @TableField("adm_del")
    private Integer admDel;


}
