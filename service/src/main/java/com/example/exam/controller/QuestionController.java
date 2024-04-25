package com.example.exam.controller;

import com.example.exam.entity.Question;
import com.example.exam.resp.RestResp;
import com.example.exam.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname: Question
 * @Author: Stonffe
 * @Date: 2024/4/18 19:42
 */
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Operation(summary = "添加题目")
    @PostMapping("addQuestion")
    public RestResp<Void> addQuestion(@RequestBody Question question) {
        questionService.save(question);
        return RestResp.ok();
    }

    @Operation(summary = "更新题目")
    @PostMapping("updateQuestion")
    public RestResp<Void> updateQuestion(@RequestBody Question question) {
        questionService.updateById(question);
        return RestResp.ok();
    }

    @Operation(summary = "删除题目")
    @GetMapping("deleteQuestion/{questionId}")
    public RestResp<Void> deleteQuestion(@PathVariable Integer questionId) {
        questionService.removeById(questionId);
        return RestResp.ok();
    }

    @Operation(summary = "发送题目")
    @PostMapping("getQuestion/{courseListId}")
    public RestResp<List<Question>> getQuestion(@PathVariable Integer courseListId) {

        return questionService.getQuestion(courseListId);
    }
}
