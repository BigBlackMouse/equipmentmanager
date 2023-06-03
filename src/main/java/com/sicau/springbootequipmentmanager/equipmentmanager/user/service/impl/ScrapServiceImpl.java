package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.ScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Usingrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.ScrapMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.UsingrecordMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.ScrapService;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UsingrecordService;
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
public class ScrapServiceImpl extends ServiceImpl<ScrapMapper, ScrapRecord> implements ScrapService {

    @Override
    public Page<ScrapRecord> getScrapPage(QueryScrapRecord queryScrapRecord) {
        Page<ScrapRecord> page = new Page<>();
        page.setSize(queryScrapRecord.getPageSize() == null ? 3 : queryScrapRecord.getPageSize());
        page.setCurrent(queryScrapRecord.getCurrentPage() == null ? 1 :queryScrapRecord.getCurrentPage());
        // TODO 校验当前用户是否为管理员

        // 返回查询结果
        QueryWrapper<ScrapRecord> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }
}
