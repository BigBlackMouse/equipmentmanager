package com.sicau.springbootequipmentmanager.equipmentmanager.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("tb_feedback")
public class TbFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fee_id", type = IdType.AUTO)
    private Integer feeId;

    @TableField("user_id")
    private String userId;

    @TableField("fee_question")
    private String feeQuestion;

    @TableField("fee_detail")
    private String feeDetail;

    @TableField("adm_message")
    private String admMessage;

    @TableField("adm_answer")
    private String admAnswer;

    @TableField("del")
    private Integer del;


}
