package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class RepairRecordInfo {
    private Integer repId;
    private Integer equId;
    private Integer admId;
    private String repReason;
    private String repPerson;
    private Float repCost;
    private Date repDate;
    private String repResult;
}
