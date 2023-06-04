package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FaultRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFaultRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface FaultrecordService extends IService<Faultrecord> {

    Page<Faultrecord> getFaultPage(QueryFaultRecord queryFaultRecord);

    Boolean addFaultRecord(FaultRecordInfo faultRecordInfo);

    Boolean deleteFaultRecordByFauId(Integer fauId, Integer userId);

    Boolean updateFault(FaultRecordInfo faultRecordInfo);

    boolean getFaultRecordAdd(FaultRecordInfo faultRecordInfo);

}
