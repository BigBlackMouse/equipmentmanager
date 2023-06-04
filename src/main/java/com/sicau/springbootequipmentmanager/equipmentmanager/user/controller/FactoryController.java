package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Factory;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-03
 */
@RestController
@RequestMapping("/api/factory")
public class FactoryController {
    @Autowired
    private FactoryService factoryService;
    @GetMapping("/detail")
    public Result<?> getEquipmentDetail(Integer facId){
        Factory info = factoryService.getFactoryDetail(facId);
        JSONObject object = new JSONObject();
        if (!Objects.isNull(info)) {
            object.put("code",200);
            object.put("msg","操作成功");
            object.put("equipment",info);
            return new Result<>().success().put(object);
        }else {
            return new Result<>().error();
        }

    }

}
