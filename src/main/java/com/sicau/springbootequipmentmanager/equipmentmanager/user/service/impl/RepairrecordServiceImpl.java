package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryRepairRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.RepairrecordMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.RepairrecordService;
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
public class RepairrecordServiceImpl extends ServiceImpl<RepairrecordMapper, Repairrecord> implements RepairrecordService {

    @Override
    public Page<Repairrecord> getRepairPage(QueryRepairRecord queryRepairRecord) {
        Page<Repairrecord> page = new Page<>();
        page.setSize(queryRepairRecord.getPageSize() == null ? 3 : queryRepairRecord.getPageSize());
        page.setCurrent(queryRepairRecord.getCurrentPage() == null ? 1 :queryRepairRecord.getCurrentPage());
        // TODO 校验当前用户是否为管理员

        // 返回查询结果
        QueryWrapper<Repairrecord> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }
}
