package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FaultRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFaultRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.FaultrecordMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FaultrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@Service
public class FaultrecordServiceImpl extends ServiceImpl<FaultrecordMapper, Faultrecord> implements FaultrecordService {

    @Autowired FaultrecordMapper faultrecordMapper;

    @Override
    public Page<Faultrecord> getFaultPage(QueryFaultRecord queryFaultRecord) {
        Page<Faultrecord> page = new Page<>();
        page.setSize(queryFaultRecord.getPageSize());
        page.setCurrent(queryFaultRecord.getCurrentPage());
        QueryWrapper<Faultrecord> wrapper = new QueryWrapper<>();
        return page(page,wrapper);


    }

    @Override
    public Boolean addFaultRecord(FaultRecordInfo faultRecordInfo) {
        Faultrecord faultrecord = new Faultrecord();
        BeanUtils.copyProperties(faultRecordInfo, faultrecord);

        // TODO 图片上传

        // 新增故障信息
        return this.save(faultrecord);
    }

    @Override
    public Boolean deleteFaultRecordByFauId(@Param("fauId")Integer fauId) {
        return this.removeById(fauId);
    }

    @Override
    public Boolean updateFault(FaultRecordInfo faultRecordInfo) {
        Faultrecord faultrecord = new Faultrecord();
        BeanUtils.copyProperties(faultRecordInfo,faultrecord);
        return this.updateById(faultrecord);
    }


    @Override
    public boolean getFaultRecordAdd(FaultRecordInfo faultRecordInfo) {
        Faultrecord faultrecord = new Faultrecord();
        BeanUtils.copyProperties(faultRecordInfo,faultrecord);
        return this.save(faultrecord);
    }

}
