package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class QueryScrapRecord {
    private Integer repId;
    private Integer equId;
    private Integer admId;
    private String scrReason;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scrDate;
    private Integer currentPage;
    private Integer pageSize;
}
