package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryRepairRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.ScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.RepairrecordService;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@RestController
@RequestMapping("/api/scraprecord")
public class ScrapRecordController {

    @Autowired
    private ScrapService scrapService;

    /**
     * 分页查询 报修信息
     * @param queryScrapRecord
     * @return
     */
    @RequestMapping("/page")
    public PageResult<?> getScrapPage(QueryScrapRecord queryScrapRecord){
        Page<ScrapRecord> scrapPage = scrapService.getScrapPage(queryScrapRecord);
        PageResult<ScrapRecord> result = new PageResult<>(
                                            scrapPage.getCurrent(),
                                            scrapPage.getSize(),
                                            scrapPage.getTotal(),
                                            scrapPage.getPages(),
                                            scrapPage.getRecords());
        result.setCode(200);
        result.setMsg("查询成功！");
        return result;
    }

}
