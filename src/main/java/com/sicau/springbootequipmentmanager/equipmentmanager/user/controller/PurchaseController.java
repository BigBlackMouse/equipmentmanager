package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.PurchaseInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-04
 */
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @PostMapping("/buy")
    public Result<?> getPurchaseBuy(@RequestBody PurchaseInfo purchaseInfo){
        boolean result = purchaseService.getPurchaseBuy(purchaseInfo);
        if (result) {
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }
}
