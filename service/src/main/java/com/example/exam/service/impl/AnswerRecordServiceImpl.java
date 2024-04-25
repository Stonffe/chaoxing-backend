package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.AnswerQuestionDto;
import com.example.exam.entity.AnswerRecord;
import com.example.exam.entity.Question;
import com.example.exam.entity.User;
import com.example.exam.mapper.AnswerRecordMapper;
import com.example.exam.mapper.QuestionMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.AnswerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: AnswerRecordServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/25 14:55
 */
@Service
public class AnswerRecordServiceImpl extends ServiceImpl<AnswerRecordMapper, AnswerRecord> implements AnswerRecordService {
    @Autowired
    private AnswerRecordMapper answerRecordMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public RestResp<Void> logAnswer(List<AnswerQuestionDto> list) {
        for (AnswerQuestionDto dto : list) {
            // 查出phoneNum对应UserId
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("phoneNum", dto.getPhoneNum());
            User user = userMapper.selectOne(userQueryWrapper);
            Question question = questionMapper.selectById(dto.getQuestionId());
            char answer = question.getAnswer();
            // 判断答案是否正确
            Integer isTrue = answer == dto.getAnswer() ? 1 : 0;
            AnswerRecord answerRecord = new AnswerRecord();
            answerRecord.setUserId(user.getUserId());
            answerRecord.setQuestionId(dto.getQuestionId());
            answerRecord.setAnswer(dto.getAnswer());
            answerRecord.setIsTrue(isTrue);
            answerRecordMapper.insert(answerRecord);
        }
        return RestResp.ok();
    }
}
