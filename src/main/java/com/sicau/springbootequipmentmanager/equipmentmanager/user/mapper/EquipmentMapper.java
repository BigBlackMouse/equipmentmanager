package com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper;

import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface EquipmentMapper extends BaseMapper<Equipment> {
    Equipment selectEquipment();
}
