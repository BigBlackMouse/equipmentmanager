package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryEquipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.ScrapRecord;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface ScrapService extends IService<ScrapRecord> {

    Page<ScrapRecord> getScrapPage(QueryScrapRecord queryScrapRecord);
}
