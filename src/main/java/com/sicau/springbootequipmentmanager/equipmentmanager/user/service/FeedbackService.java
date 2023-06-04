package com.sicau.springbootequipmentmanager.equipmentmanager.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FeedBackInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFeedBack;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 软件工程实训：2023/5/25
 * @since 2023-06-02
 */
public interface FeedbackService extends IService<Feedback> {

    Page<Feedback> getFeedbackPage(QueryFeedBack queryFeedBack);

    Boolean deleteFeedbackByFeeId(Integer feeId);

    Boolean addFeedback(FeedBackInfo feedBackInfo);

    Boolean updateFeedback(FeedBackInfo feedBackInfo);
}
