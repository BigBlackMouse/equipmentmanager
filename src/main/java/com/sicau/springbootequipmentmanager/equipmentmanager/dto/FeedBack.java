package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class FeedBack {
    private Integer feeId;
    private Integer userId;
    private String  feeQuestion;
    private String  feeDetail;
    private String  adminMessage;
    private String  adminAnswer;
    private String  del;

}
