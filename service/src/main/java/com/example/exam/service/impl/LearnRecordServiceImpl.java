package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.LearnRecord;
import com.example.exam.mapper.LearnRecordMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.LearnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: LearnRecordServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/17 23:57
 */
@Service
public class LearnRecordServiceImpl extends ServiceImpl<LearnRecordMapper, LearnRecord> implements LearnRecordService {
    @Autowired
    private LearnRecordMapper learnRecordMapper;

    /**
     * 查询学习记录
     *
     * @param phoneNum
     * @param type
     * @return
     */
    @Override
    public RestResp<List<LearnRecord>> getLearnRecord(String phoneNum, int type) {
        QueryWrapper<LearnRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phoneNum);
        wrapper.eq("type", type);
        List<LearnRecord> list = learnRecordMapper.selectList(wrapper);
        return RestResp.ok(list);
    }
}
