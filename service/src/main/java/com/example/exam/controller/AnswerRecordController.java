package com.example.exam.controller;

import com.example.exam.dto.AnswerQuestionDto;
import com.example.exam.resp.RestResp;
import com.example.exam.service.AnswerRecordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname: AnswerRecordController
 * @Author: Stonffe
 * @Date: 2024/4/25 19:46
 */
@RestController
public class AnswerRecordController {
    @Autowired
    private AnswerRecordService answerRecordService;

    @Operation(summary = "记录答题情况")
    @PostMapping("logAnswer")
    public RestResp<Void> logAnswer(@RequestBody List<AnswerQuestionDto> list) {
        return answerRecordService.logAnswer(list);
    }
}
