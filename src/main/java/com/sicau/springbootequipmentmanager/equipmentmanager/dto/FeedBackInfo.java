package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class FeedBackInfo {
    private Integer feeId;
    private Integer userId;
    private String  feeQuestion;
    private String  feeDetail;
    private String  admMessage;
    private String  admAnswer;
    private String  del;

}
