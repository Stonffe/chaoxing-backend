package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.LearnRecordDto;
import com.example.exam.vo.LearnRecordVo;
import com.example.exam.entity.LearnRecord;
import com.example.exam.resp.RestResp;

import java.util.List;

/**
 * @Classname: LearnRecordService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/17 23:56
 */
public interface LearnRecordService extends IService<LearnRecord> {
    /**
     * 查询学习记录
     *
     * @param learnRecordDto
     * @return
     */
    RestResp<List<LearnRecord>> getLearnRecord(LearnRecordDto learnRecordDto);

    /**
     * 查询一个学生的学习情况
     *
     * @param courseId
     * @param phoneNum
     * @return
     */
    RestResp<LearnRecordVo> learnSituation(Integer courseId, String phoneNum);

    /**
     * 查询整个课程学生完成情况
     *
     * @param courseId
     * @return
     */
    RestResp<List<LearnRecordVo>> allLearnSituation(Integer courseId);

    /**
     * 添加学习记录
     *
     * @param learnRecord
     * @return
     */
    RestResp<Void> addLearnRecord(LearnRecord learnRecord);

    /**
     * 查询视频观看数量情况
     *
     * @param courseId
     * @param phoneNum
     * @return
     */
    RestResp<LearnRecordVo> videoSituation(Integer courseId, String phoneNum);
}
