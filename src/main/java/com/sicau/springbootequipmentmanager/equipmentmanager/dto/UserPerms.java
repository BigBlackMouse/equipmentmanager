package com.sicau.springbootequipmentmanager.equipmentmanager.dto;

import lombok.Data;

@Data
public class UserPerms {
    private Integer userId;
    private String userName;
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private Integer permsId;
    private String permsCode;
    private String permsName;
}
