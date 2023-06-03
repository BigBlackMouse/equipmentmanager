package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class FaultRecordInfo {
    private Integer fauId;
    private Integer admId;
    private Integer equId;
    private Integer userId;
    private Date fauOccurDate;
    private String fauOccurPosition;
    private String  fauDetail;
    private String fauImg;
    private String  admAnswer;
    private String  adminDel;
    private String  userDel;
    private String  admMessage;


}
