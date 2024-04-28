package com.example.exam.controller;

import com.example.exam.dto.LearnRecordDto;
import com.example.exam.vo.LearnRecordVo;
import com.example.exam.entity.LearnRecord;
import com.example.exam.resp.RestResp;
import com.example.exam.service.LearnRecordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname: LearnRecordController
 * @Author: Stonffe
 * @Date: 2024/4/18 0:05
 */
@RestController
public class LearnRecordController {
    @Autowired
    private LearnRecordService learnRecordService;

    @Operation(summary = "查询学习记录")
    @PostMapping("/getLearnRecord")
    public RestResp<List<LearnRecord>> getLearnRecord(@RequestBody LearnRecordDto learnRecordDto) {
        return learnRecordService.getLearnRecord(learnRecordDto);
    }

    @Operation(summary = "添加学习记录")
    @PostMapping("addLearnRecord")
    public RestResp<Void> addLearnRecord(@RequestBody LearnRecord learnRecord) {
        return learnRecordService.addLearnRecord(learnRecord);
    }

    @Operation(summary = "查询一个用户的课程学习情况")
    @GetMapping("learnSituation/{courseId}/{phoneNum}")
    public RestResp<LearnRecordVo> learnSituation(@PathVariable Integer courseId,
                                                  @PathVariable String phoneNum) {
        return learnRecordService.learnSituation(courseId, phoneNum);
    }

    @Operation(summary = "查询一个课程所有学生完成情况")
    @GetMapping("allLearnSituation/{courseId}")
    public RestResp<List<LearnRecordVo>> allLearnSituation(@PathVariable Integer courseId) {
        return learnRecordService.allLearnSituation(courseId);
    }

    @Operation(summary = "查询视频观看数量情况")
    @GetMapping("videoSituation/{courseId}/{phoneNum}")
    public RestResp<LearnRecordVo> videoSituation(@PathVariable Integer courseId,
                                                  @PathVariable String phoneNum) {
        return learnRecordService.videoSituation(courseId, phoneNum);
    }
}
