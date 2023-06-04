package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryUsingRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UsingrecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Usingrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UsingrecordService;
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
@RequestMapping("/api/usingrecord")
public class UsingrecordController {
    @Autowired
    private UsingrecordService usingrecordService;
    @PostMapping("/rent")
    public Result<?> getEquipmentRent(@RequestBody UsingrecordInfo usingrecordInfo){
        boolean result = usingrecordService.getEquipmentRent(usingrecordInfo);
        if (result) {
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @RequestMapping("/page")
    public PageResult<?> getUsingRecordPage(QueryUsingRecord queryUsingRecord){
        Page<Usingrecord> page = usingrecordService.getUsingRecordPage(queryUsingRecord);
        PageResult<Usingrecord> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @GetMapping("/search")
    public PageResult<?> getUsingRecordSearch(QueryUsingRecord queryUsingRecord){
        Page<Usingrecord> usingrecordPage = usingrecordService.getUsingRecordSearch(queryUsingRecord);
        PageResult<Usingrecord> result = new PageResult<>(usingrecordPage.getCurrent(),usingrecordPage.getSize(),usingrecordPage.getTotal(),usingrecordPage.getPages(),usingrecordPage.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @GetMapping("/delete")
    public Result<?> getUsingRecordDelete(Integer usiId){
        boolean result = usingrecordService.getUsingRecordDelete(usiId);
        if (result) {
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }
}
