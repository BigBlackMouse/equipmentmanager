package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class FaultRecordInfo {
    private Integer fauId;
    private Integer adminId;
    private Integer equId;
    private Integer userId;
    private Date fauOccurDate;
    private String fauOccurPosition;
    private String  fauDetail;
    private String  adminAnswer;
    private String  adminDel;
    private String  userDel;
    private String  adminMessage;


}
