package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryEquipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.EquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private EquipmentService equipmentService;
    @RequestMapping("/page")
    public PageResult<?> getUserPage(QueryEquipment queryEquipment){
        Page<Equipment> equipmentPage = equipmentService.getEquipmentPage(queryEquipment);
        PageResult<Equipment> result = new PageResult<>(equipmentPage.getCurrent(),equipmentPage.getSize(),equipmentPage.getTotal(),equipmentPage.getPages(),equipmentPage.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

}
