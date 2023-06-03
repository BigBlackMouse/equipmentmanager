package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class QueryFaultRecord {
    private Integer currentPage;
    private Integer pageSize;
    private Integer fauId;
    private Integer admId;
    private Integer equId;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fauOccurDate;
    private String fauOccurPosition;
    private String  fauDetail;
    private String  admAnswer;
    private String  adminDel;
    private String  userDel;
    private String  admMessage;
}
