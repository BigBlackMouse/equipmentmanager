package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryUsingRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UsingrecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Usingrecord;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface UsingrecordService extends IService<Usingrecord> {
    boolean getEquipmentRent(UsingrecordInfo usingrecordInfo);
    Page<Usingrecord> getUsingRecordPage(QueryUsingRecord queryUsingRecord);
    Page<Usingrecord> getUsingRecordSearch(QueryUsingRecord queryUsingRecord);
    boolean getUsingRecordDelete(Integer usiId);
}
