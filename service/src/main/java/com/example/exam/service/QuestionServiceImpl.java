package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.Question;
import com.example.exam.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
 * @Classname: QuestionServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/18 19:23
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
}
