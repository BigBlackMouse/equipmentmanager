package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseInfo {

    private Integer purId;

    private String userId;

    private String equName;

    private String purApplyreason;

    private Integer purPurchasenumber;

    private Float purPrice;

    private LocalDate purApplydate;

    private String admDealstatus;

    private String admReply;
}
