package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryEquipment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @GetMapping("/page")
    public PageResult<?> getUserPage(QueryEquipment queryEquipment){
        return null;
    }

}
