package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.entity.Question;
import com.example.exam.resp.RestResp;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Classname: QuestionService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/18 19:23
 */
public interface QuestionService extends IService<Question> {
    /**
     * 发送整个题目的信息
     *
     * @param courseListId
     * @return
     */
    RestResp<List<Question>> getQuestion(Integer courseListId);

    RestResp<Void> addQuestion(Question question);

    RestResp<Void> updateQuestion(Question question);
}
