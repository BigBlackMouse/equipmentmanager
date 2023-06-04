package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Factory;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.FactoryMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FactoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-03
 */
@Service
public class FactoryServiceImpl extends ServiceImpl<FactoryMapper, Factory> implements FactoryService {
    @Override
    public Factory getFactoryDetail(Integer facId) {
        QueryWrapper<Factory> wrapper = new QueryWrapper<>();
        wrapper.eq("fac_id",facId);

        return this.getOne(wrapper);
    }
}
