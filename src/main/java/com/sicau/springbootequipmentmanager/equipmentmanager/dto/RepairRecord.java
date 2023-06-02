package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class RepairRecord {
    private Integer repId;
    private Integer euqId;
    private Integer adminId;
    private String repReason;
    private String repPerson;
    private String repCost;
    private Date repDate;
    private String repResult;
}
