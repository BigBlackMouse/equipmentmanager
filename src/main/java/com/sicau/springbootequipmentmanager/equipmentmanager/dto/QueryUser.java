package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class QueryUser {
    private String userId;
    private String userPassword;
    private String userName;
    private String userType;
    private String userAcademy;
    private String userEmail;
    private String userPhone;
    private Integer currentPage;
    private Integer pageSize;
}
