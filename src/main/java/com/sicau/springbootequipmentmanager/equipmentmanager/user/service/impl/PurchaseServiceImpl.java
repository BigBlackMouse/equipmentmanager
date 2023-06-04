package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.PurchaseInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Purchase;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.PurchaseMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.PurchaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-04
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Override
    public boolean getPurchaseBuy(PurchaseInfo purchaseInfo) {
        Purchase purchase = new Purchase();
        BeanUtils.copyProperties(purchaseInfo,purchase);
        return this.save(purchase);
    }
}
