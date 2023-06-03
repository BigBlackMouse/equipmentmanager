package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.PageResult;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FaultRecordInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.FeedBackInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryFeedBack;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.QueryScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Faultrecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.Feedback;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.ScrapRecord;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.FeedbackService;
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
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 分页查询 反馈信息
     * @param queryFeedBack
     * @return
     */
    @RequestMapping("/page")
    public PageResult<?> getScrapPage(QueryFeedBack queryFeedBack){
        Page<Feedback> feedbackPage = feedbackService.getFeedbackPage(queryFeedBack);
        PageResult<Feedback> result = new PageResult<>(
                feedbackPage.getCurrent(),
                feedbackPage.getSize(),
                feedbackPage.getTotal(),
                feedbackPage.getPages(),
                feedbackPage.getRecords());
        result.setCode(200);
        result.setMsg("查询成功！");
        return result;
    }

    /**
     * 删除反馈
     * @param feeId
     * @return
     */
    @DeleteMapping("/delete")
    public Result<?> deleteFeedback(@RequestParam("feeId") Integer feeId){
        Boolean status = feedbackService.deleteFeedbackByFeeId(feeId);
        Result result = new Result();
        if(status){
            result.success(200,"删除成功！");
        }else {
            result.error(400, "删除异常");
        }
        return result;
    }


    /**
     * 删除反馈
     * @param feedBackInfo
     * @return
     */
    @PostMapping("/add")
    public Result<?> addFeedback(@RequestBody FeedBackInfo feedBackInfo){
        Boolean status = feedbackService.addFeedback(feedBackInfo);
        Result result = new Result();
        if(status){
            result.success(200,"添加成功！");
        }else {
            result.error(400, "添加异常");
        }
        return result;
    }

    /**
     * 回复用户
     * @param admAnswer
     * @param feeId
     * @return
     */
    @PutMapping("/resolve/reply")
    public Result<?> resolveFaultByReply(@RequestParam("admAnswer")String admAnswer,
                                         @RequestParam("feeId")Integer feeId){
        // 转entity
        Feedback feedback = new Feedback ();
        feedback.setFeeId(feeId);
        feedback.setAdmAnswer(admAnswer);
        // 处理
        Boolean status = feedbackService.updateFeedback(feedback);
        Result result = new Result();
        if(status){
            result.success(200,"回复成功！");
        }else {
            result.error(400, "回复异常");
        }
        return result;
    }




}
