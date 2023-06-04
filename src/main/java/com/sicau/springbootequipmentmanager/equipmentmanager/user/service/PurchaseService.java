package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.PurchaseInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Purchase;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-04
 */
public interface PurchaseService extends IService<Purchase> {
    boolean getPurchaseBuy(PurchaseInfo purchaseInfo);
}
