package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Factory;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-03
 */
public interface FactoryService extends IService<Factory> {
    Factory getFactoryDetail(Integer facId);
}
