package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryUsingRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UsingrecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Usingrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.UsingrecordMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UsingrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
public class UsingrecordServiceImpl extends ServiceImpl<UsingrecordMapper, Usingrecord> implements UsingrecordService {
    @Override
    public boolean getEquipmentRent(UsingrecordInfo usingrecordInfo) {
        Usingrecord usingrecord = new Usingrecord();
        BeanUtils.copyProperties(usingrecordInfo,usingrecord);
        return this.save(usingrecord);
    }

    @Override
    public Page<Usingrecord> getUsingRecordPage(QueryUsingRecord queryUsingRecord) {
        Page<Usingrecord> page = new Page<>();
        page.setSize(queryUsingRecord.getPageSize());
        page.setCurrent(queryUsingRecord.getCurrentPage());
        QueryWrapper<Usingrecord> wrapper = new QueryWrapper<>();

        return page(page,wrapper);
    }

    @Override
    public Page<Usingrecord> getUsingRecordSearch(QueryUsingRecord queryUsingRecord) {
        QueryWrapper<Usingrecord> wrapper = new QueryWrapper<>();
        wrapper.eq("equ_id",queryUsingRecord.getEquId());
        Page<Usingrecord> objectPage = new Page<>();
        objectPage.setCurrent(queryUsingRecord.getCurrentPage());
        objectPage.setSize(queryUsingRecord.getPageSize());
        return page(objectPage,wrapper);
    }

    @Override
    public boolean getUsingRecordDelete(Integer usiId) {
        return this.removeById(usiId);
    }
}
