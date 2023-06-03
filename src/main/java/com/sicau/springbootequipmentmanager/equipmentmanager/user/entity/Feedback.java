package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("feedback")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fee_id", type = IdType.AUTO)
    private Integer feeId;

    @TableField("user_id")
    private Integer userId;

    @TableField("fee_question")
    private String feeQuestion;

    @TableField("fee_detail")
    private String feeDetail;

    @TableField("adm_message")
    private String admMessage;

    @TableField("adm_answer")
    private String admAnswer;

    @TableLogic
    @TableField("del")
    private Integer del;


}
