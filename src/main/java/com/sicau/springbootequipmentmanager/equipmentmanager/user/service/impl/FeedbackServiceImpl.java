package com.sicau.springbootequipmentmanager.equipmentmanager.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FeedBackInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFeedBack;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryRepairRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Feedback;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Repairrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.mapper.FeedbackMapper;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
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
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Override
    public Page<Feedback> getFeedbackPage(QueryFeedBack queryFeedBack) {
        Page<Feedback> page = new Page<>();
        page.setSize(queryFeedBack.getPageSize());
        page.setCurrent(queryFeedBack.getCurrentPage());
        // TODO 校验当前用户是否为管理员

        // 返回查询结果
        QueryWrapper<Feedback> wrapper = new QueryWrapper<>();
        return page(page,wrapper);

    }

    @Override
    public Boolean deleteFeedbackByFeeId(Integer feeId) {
        return this.removeById(feeId);
    }

    @Override
    public Boolean addFeedback(FeedBackInfo feedBackInfo) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedBackInfo,feedback);
        boolean status = this.save(feedback);
        return status;
    }

    @Override
    public Boolean updateFeedback(FeedBackInfo feedBackInfo) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedBackInfo,feedback);
        return this.updateById(feedback);
    }

}
