package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.EquipmentInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryEquipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.EquipmentMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.EquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    @Override
    public Page<Equipment> getEquipmentPage(QueryEquipment queryEquipment) {
        Page<Equipment> page = new Page<>();
        page.setSize(queryEquipment.getPageSize() == null ? 10 : queryEquipment.getPageSize());
        page.setCurrent(queryEquipment.getCurrentPage() == null ? 1 :queryEquipment.getCurrentPage());
        QueryWrapper<Equipment> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }
}
