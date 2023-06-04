package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.EquipmentInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryEquipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.EquipmentMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.EquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Override
    public Page<Equipment> getEquipmentPage(QueryEquipment queryEquipment) {
        Page<Equipment> page = new Page<>();
        page.setCurrent(queryEquipment.getCurrentPage());
        page.setSize(queryEquipment.getPageSize());
        QueryWrapper<Equipment> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }

    @Override
    public Page<Equipment> getEquipmentSearch(QueryEquipment queryEquipment) {
        Page<Equipment> equipmentPage = new Page<>();
        equipmentPage.setSize(queryEquipment.getPageSize());
        equipmentPage.setCurrent(queryEquipment.getCurrentPage());
        QueryWrapper<Equipment> wrapper = new QueryWrapper<>();
        if (queryEquipment.getEquName() != null) {
            wrapper.eq("equ_name",queryEquipment.getEquName());
        }
        if (queryEquipment.getEquType() != null) {
            wrapper.eq("equ_type",queryEquipment.getEquType());
        }
        if (queryEquipment.getEquId() != null) {
            wrapper.eq("equ_id",queryEquipment.getEquId());
        }
        if (queryEquipment.getEquName() != null && queryEquipment.getEquType() != null) {
            wrapper.eq("equ_name",queryEquipment.getEquName()).eq("equ_type",queryEquipment.getEquType());
        }
        if (queryEquipment.getEquName() != null && queryEquipment.getEquId() != null) {
            wrapper.eq("equ_name",queryEquipment.getEquName()).eq("equ_id",queryEquipment.getEquId());
        }
        if (queryEquipment.getEquType() != null && queryEquipment.getEquId() != null) {
            wrapper.eq("equ_type",queryEquipment.getEquType()).eq("equ_id",queryEquipment.getEquId());
        }
        if (queryEquipment.getEquName() != null && queryEquipment.getEquType() != null && queryEquipment.getEquId() != null) {
            wrapper.eq("equ_name",queryEquipment.getEquName()).eq("equ_type",queryEquipment.getEquType()).eq("equ_id",queryEquipment.getEquId());
        }
        return page(equipmentPage,wrapper);
    }

    @Override
    public boolean getEquipmentAdd(EquipmentInfo equipmentInfo) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentInfo,equipment);
        return this.save(equipment);
    }

    @Override
    public Page<Equipment> getEquipmentType(QueryEquipment queryEquipment) {
        Page<Equipment> page = new Page<>();
        QueryWrapper<Equipment> wrapper = new QueryWrapper<>();
        page.setCurrent(queryEquipment.getCurrentPage());
        page.setSize(queryEquipment.getPageSize());
        wrapper.groupBy("equ_type");
        return page(page,wrapper);
    }

}
