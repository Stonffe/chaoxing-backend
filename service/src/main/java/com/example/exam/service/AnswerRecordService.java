package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.AnswerQuestionDto;
import com.example.exam.entity.AnswerRecord;
import com.example.exam.resp.RestResp;

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
     * @param list
     * @return
     */
    RestResp<Void> logAnswer(List<AnswerQuestionDto> list);
}
