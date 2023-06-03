package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFaultRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryRepairRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.RepairrecordService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/repairrecord")
public class RepairrecordController {

    @Autowired
    private RepairrecordService repairrecordService;

    /**
     * 分页查询 报修信息
     * @param queryRepairRecord
     * @return
     */
    @RequestMapping("/page")
    public PageResult<?> getFaultPage(QueryRepairRecord queryRepairRecord){
        Page<Repairrecord> repairPage = repairrecordService.getRepairPage(queryRepairRecord);
        PageResult<Repairrecord> result = new PageResult<>(
                repairPage.getCurrent(),
                repairPage.getSize(),
                repairPage.getTotal(),
                repairPage.getPages(),
                repairPage.getRecords());
        result.setCode(200);
        result.setMsg("查询成功！");
        return result;
    }

}
