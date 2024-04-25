package com.example.exam.controller;

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
    @GetMapping("/getLearnRecord/{phoneNum}/{type}")
    public RestResp<List<LearnRecord>> getLearnRecord(@PathVariable String phoneNum, @PathVariable int type) {
        return learnRecordService.getLearnRecord(phoneNum, type);
    }

    @Operation(summary = "添加学习记录")
    @PostMapping("addLearnRecord")
    public RestResp<Void> addLearnRecord(@RequestBody LearnRecord learnRecord) {
        learnRecordService.save(learnRecord);
        return RestResp.ok();
    }
}
