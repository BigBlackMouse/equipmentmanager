package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
@Data
public class QueryRepairRecord {
    private Integer repId;
    private Integer euqId;
    private Integer adminId;
    private String repReason;
    private String repPerson;
    private String repCost;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date repDate;
    private String repResult;
    private Integer currentPage;
    private Integer pageSize;
}
