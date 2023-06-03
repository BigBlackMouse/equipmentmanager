package com.sicau.springbootequipmentmanager.equipmentmanager.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ScrapRecordInfo {
    private Integer repId;
    private Integer equId;
    private Integer admId;
    private String scrReason;
    private Date scrDate;
}
