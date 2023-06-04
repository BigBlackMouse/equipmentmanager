package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FaultRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFaultRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.RepairRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.ScrapRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.ScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FaultrecordService;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.RepairrecordService;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.ScrapService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  设备故障记录
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
@Slf4j
@RestController
@RequestMapping("/api/faultrecord")
public class FaultrecordController {

    @Autowired
    private FaultrecordService faultrecordService;

    @Autowired
    private RepairrecordService repairrecordService;

    @Autowired
    private ScrapService scrapService;

    /**
     * 分页查询故障设备记录
     * @param queryFaultRecord
     * @return
     */
    @RequestMapping("/page")
    public PageResult<?> getFaultPage(QueryFaultRecord queryFaultRecord){
        Page<Faultrecord> faultPage = faultrecordService.getFaultPage(queryFaultRecord);
        PageResult<Faultrecord> result = new PageResult<>(
                                            faultPage.getCurrent(),
                                            faultPage.getSize(),
                                            faultPage.getTotal(),
                                            faultPage.getPages(),
                                            faultPage.getRecords());
        result.setCode(200);
        result.setMsg("查询成功！");
        return result;
    }

    /**
     * 新增设备故障信息
     * @param faultRecordInfo
     * @return
     */
    @PostMapping("/add")
    public Result<?> addFault(FaultRecordInfo faultRecordInfo,
                              @RequestParam("file") MultipartFile file){
        Result result = new Result();
        try {
            // 获取文件的后缀
            String extension = "." + FilenameUtils.getExtension(file.getOriginalFilename());
            // 获取文件的类型
            String type = file.getContentType();
            if(!type.startsWith("image")){
                return result.error(400, "只能上传图片！");
            }
            // 新文件名
            String newFileName =  new SimpleDateFormat("yyyymmddHHmmss").format(new Date())+ UUID.randomUUID().toString().replace("-","") + extension;
            // 存对象
            String imgdir = "img";
            faultRecordInfo.setFauImg(imgdir + "/" + newFileName);
            // 生成目录
            String localContainer = "/static/" + imgdir;
            String uploadPath = ResourceUtils.getURL("classpath:").getPath() + localContainer;
            File dirPath = new File(uploadPath);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            // 处理文件上传
            file.transferTo(new File(dirPath, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 存数据库
        Boolean status = faultrecordService.addFaultRecord(faultRecordInfo);
        if(status){
            result.success(200,"添加成功！");
        }else {
            result.error(400, "添加异常");
        }
        return result;
    }

    @PostMapping("upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) {

        Map<String, String> res = new HashMap<>();
        try {
            String fileN = file.getOriginalFilename();
            // 获取文件的原始名称
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());
            // 获取文件的类型
            String type = file.getContentType();
            // 新文件名
            String newFileName =  new SimpleDateFormat("yyyymmddHHmmss").format(new Date())+ UUID.randomUUID().toString().replace("-","") + extension;
            // 生成目录
            String localContainer = "/static/img";
            String uploadPath = ResourceUtils.getURL("classpath:").getPath() + localContainer;
            File dirPath = new File(uploadPath);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            // 处理文件上传
            file.transferTo(new File(dirPath, newFileName));

            res.put("code", "0");
            res.put("msg", "上传成功");
            res.put("url", "/fileStorage/file/index");
        } catch (IOException e) {
            e.printStackTrace();
            res.put("code", "-1");
            res.put("msg", "上传失败");
            res.put("url", "/fileStorage/file/index");
        }

        return res;
    }


    /**
     * 删除故障信息
     * @return
     */
    @DeleteMapping("/delete")
    public Result<?> deleteFault(Integer fauId, Integer userId){
        Boolean status = faultrecordService.deleteFaultRecordByFauId(fauId, userId);
        Result result = new Result();
        if(status){
            result.success(200,"删除成功！");
        }else {
            result.error(400, "删除异常");
        }
        return result;
    }

    /**
     * 处理故障：1.回复用户
     * @return
     */
    @PutMapping("/resolve/reply")
    public Result<?> resolveFaultByReply(FaultRecordInfo faultRecordInfo){
        // 处理
        Boolean status = faultrecordService.updateFault(faultRecordInfo);
        Result result = new Result();
        if(status){
            result.success(200,"回复成功！");
        }else {
            result.error(400, "回复异常");
        }
        return result;
    }


    /**
     * 处理故障：2.报修
     * @param repairRecordInfo
     * @return
     */
    @PutMapping("/resolve/repair")
    public Result<?> resolveFaultByRepair(@RequestBody RepairRecordInfo repairRecordInfo){
        Repairrecord repairrecord = new Repairrecord();
        BeanUtils.copyProperties(repairRecordInfo, repairrecord);
        Boolean status = repairrecordService.save(repairrecord);
        Result result = new Result();
        if(status){
            result.success(200,"回复成功！");
        }else {
            result.error(400, "回复异常");
        }
        return result;
    }


    /**
     * 处理故障：3.报废
     * @param scrapRecordInfo
     * @return
     */
    @PutMapping("/resolve/scrap")
    public Result<?> resolveFaultByScrap(@RequestBody ScrapRecordInfo scrapRecordInfo){
        ScrapRecord scrapRecord = new ScrapRecord();
        BeanUtils.copyProperties(scrapRecordInfo, scrapRecord);
        Boolean status = scrapService.save(scrapRecord);
        Result result = new Result();
        if(status){
            result.success(200,"回复成功！");
        }else {
            result.error(400, "回复异常");
        }
        return result;
    }








}
