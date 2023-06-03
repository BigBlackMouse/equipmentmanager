package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FaultRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFaultRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Equipment;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.FaultrecordMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FaultrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FaultrecordServiceImpl extends ServiceImpl<FaultrecordMapper, Faultrecord> implements FaultrecordService {

    @Autowired FaultrecordMapper faultrecordMapper;

    @Override
    public Page<Faultrecord> getFaultPage(QueryFaultRecord queryFaultRecord) {
        Page<Faultrecord> page = new Page<>();
        page.setSize(queryFaultRecord.getPageSize() == null ? 3 : queryFaultRecord.getPageSize());
        page.setCurrent(queryFaultRecord.getCurrentPage() == null ? 1 :queryFaultRecord.getCurrentPage());
        // 得到当前登录的执行查询的用户
        Boolean isAdmin = true;
        Integer executor = queryFaultRecord.getAdmId();
        if(executor == null){
            executor = queryFaultRecord.getUserId();
            isAdmin = false;
        }
        if(executor == null){
            throw new RuntimeException("没有登录用户");
        }
        // 返回查询结果
        QueryWrapper<Faultrecord> wrapper = new QueryWrapper<>();
        if(isAdmin){
            // 管理员返回所有
            return page(page,wrapper);
        }else{
            // 普通用户返回由他提交的
            wrapper.eq("user_id",executor);
            // 用户级别的逻辑删除
            wrapper.eq("user_del",0);
            return page(page,wrapper);
        }

    }

    @Override
    public Boolean addFaultRecord(FaultRecordInfo faultRecordInfo) {
        Faultrecord faultrecord = new Faultrecord();
        BeanUtils.copyProperties(faultRecordInfo, faultrecord);

        // TODO 图片上传

        // 新增故障信息
        boolean status = this.save(faultrecord);
        return status;
    }

    @Override
    public Boolean deleteFaultRecordByFauId(@Param("fauId")Integer fauId,
                                            @Param("admId")Integer admId,
                                            @Param("userId")Integer userId) {
        Integer count = 0;
        // 判断由什么身份删除
        if(admId != null){
            return this.removeById(fauId);
        }else{
            count = faultrecordMapper.userLogicDeleteByFauId(fauId);
        }
        Boolean status = count != 0 ? true : false;
        return status;
    }

    @Override
    public Boolean updateFault(Faultrecord faultRecord) {
        boolean status = this.updateById(faultRecord);
        return status;
    }


}
