package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.AnswerQuestionDto;
import com.example.exam.entity.AnswerRecord;
import com.example.exam.resp.RestResp;
import com.example.exam.vo.AnswerRecordVo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Classname: AnswerRecordService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/25 14:55
 */
public interface AnswerRecordService extends IService<AnswerRecord> {
    /**
     * 记录答题情况
     *
     * @param dto
     * @return
     */
    RestResp<Void> logAnswer(AnswerQuestionDto dto);

    /**
     * 查询答题情况
     *
     * @param phoneNum
     * @param courseListId
     * @return
     */
    RestResp<List<AnswerRecord>> selectAnswerRecord(String phoneNum, int courseListId);

    /**
     * 判断题目是否完成
     *
     * @param phoneNum
     * @param questionId
     * @return
     */
    RestResp<Integer> isCompleted(String phoneNum, int questionId);

    /**
     * 用户一个课时的答题正确数量统计
     *
     * @param phoneNum
     * @param courseListId
     * @return
     */
    RestResp<AnswerRecordVo> sectionStatistics(String phoneNum, Integer courseListId);

    /**
     * 用户一个课程的答题正确数量统计
     *
     * @param phoneNum
     * @param courseId
     * @return
     */
    RestResp<AnswerRecordVo> allStatistics(String phoneNum, Integer courseId);

    /**
     * 一个课程所用用户的答题正确数量统计
     *
     * @param courseId
     * @return
     */
    RestResp<List<AnswerRecordVo>> allUserStatistics(Integer courseId);
}
