package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryRepairRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface RepairrecordService extends IService<Repairrecord> {

    Page<Repairrecord> getRepairPage(QueryRepairRecord queryRepairRecord);
}
