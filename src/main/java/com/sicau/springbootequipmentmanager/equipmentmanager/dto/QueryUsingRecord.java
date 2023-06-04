package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class QueryUsingRecord {
    private Integer usiId;
    private String userId;
    private Integer equId;
    private String admId;
    private String usiReason;
    private String usiNumber;
    private String usiDate;
    private String usiReturndate;
    private String usiApplystatus;
    private String admFeedbackapply;
    private String usiReturnstatus;
    private String admFeedbackreturn;
    private Integer userDel;
    private Integer admDel;
    private String equName;
    private Integer currentPage;
    private Integer pageSize;
}
