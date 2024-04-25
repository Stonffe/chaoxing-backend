package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.Question;
import com.example.exam.mapper.QuestionMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: QuestionServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/18 19:23
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 发送整个题目的信息，前端判断对错情况
     *
     * @param courseListId
     * @return
     */
    @Override
    public RestResp<List<Question>> getQuestion(Integer courseListId) {
        QueryWrapper<Question> wrapper = new QueryWrapper<>();
        wrapper.eq("courseListId", courseListId);
        List<Question> list = questionMapper.selectList(wrapper);
        return RestResp.ok(list);
    }
}
