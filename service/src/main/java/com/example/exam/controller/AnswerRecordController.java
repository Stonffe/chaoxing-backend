package com.example.exam.controller;

import com.example.exam.dto.AnswerQuestionDto;
import com.example.exam.entity.AnswerRecord;
import com.example.exam.resp.RestResp;
import com.example.exam.service.AnswerRecordService;
import com.example.exam.vo.AnswerRecordVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public RestResp<Void> logAnswer(@RequestBody AnswerQuestionDto dto) {
        return answerRecordService.logAnswer(dto);
    }

    @Operation(summary = "查询答题情况")
    @GetMapping("selectAnswerRecord/{phoneNum}/{courseListId}")
    public RestResp<List<AnswerRecord>> selectAnswerRecord(@PathVariable String phoneNum,
                                                           @PathVariable int courseListId) {
        return answerRecordService.selectAnswerRecord(phoneNum, courseListId);
    }

    @Operation(summary = "判断题目是否已经完成")
    @GetMapping("isCompleted/{phoneNum}/{questionId}")
    public RestResp<Integer> isCompleted(@PathVariable String phoneNum,
                                         @PathVariable int questionId) {
        return answerRecordService.isCompleted(phoneNum, questionId);
    }

    @Operation(summary = "用户一个课时的答题正确数量统计")
    @GetMapping("sectionStatistics/{phoneNum}/{courseListId}")
    public RestResp<AnswerRecordVo> sectionStatistics(@PathVariable String phoneNum,
                                                      @PathVariable Integer courseListId) {
        return answerRecordService.sectionStatistics(phoneNum, courseListId);
    }

    @Operation(summary = "用户一个课程的答题正确数量统计")
    @GetMapping("allStatistics/{phoneNum}/{courseId}")
    public RestResp<AnswerRecordVo> allStatistics(@PathVariable String phoneNum,
                                                  @PathVariable Integer courseId) {
        return answerRecordService.allStatistics(phoneNum, courseId);
    }

    @Operation(summary = "一个课程所用用户的答题正确数量统计")
    @GetMapping("allUserStatistics/{courseId}")
    public RestResp<List<AnswerRecordVo>> allUserStatistics(@PathVariable Integer courseId) {
        return answerRecordService.allUserStatistics(courseId);
    }
}
