package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
     * @param phoneNum
     * @param type
     * @return
     */
    RestResp<List<LearnRecord>> getLearnRecord(String phoneNum, int type);
}
