package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.EquipmentInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryEquipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @RequestMapping("/page")
    public PageResult<?> getUserPage(QueryEquipment queryEquipment){
        Page<Equipment> equipmentPage = equipmentService.getEquipmentPage(queryEquipment);
        PageResult<Equipment> result = new PageResult<>(equipmentPage.getCurrent(),equipmentPage.getSize(),equipmentPage.getTotal(),equipmentPage.getPages(),equipmentPage.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }
    @GetMapping("/search")
    public PageResult<?> getEquipmentSearch(QueryEquipment queryEquipment){
        Page<Equipment> page = equipmentService.getEquipmentSearch(queryEquipment);
        PageResult<Equipment> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }
    @PostMapping("/add")
    public Result<?> getEquipmentAdd(@RequestBody EquipmentInfo equipmentInfo){
        boolean result = equipmentService.getEquipmentAdd(equipmentInfo);
        if (result) {
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @GetMapping("/type")
    public PageResult<?> getEquipment(QueryEquipment queryEquipment){
        Page<Equipment> page = equipmentService.getEquipmentType(queryEquipment);
        PageResult<Equipment> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }
}
