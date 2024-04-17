package com.example.exam.controller;

import com.example.exam.entity.LearnRecord;
import com.example.exam.resp.RestResp;
import com.example.exam.service.LearnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getLearnRecord/{phoneNum}/{type}")
    public RestResp<List<LearnRecord>> getLearnRecord(@PathVariable String phoneNum, @PathVariable int type) {
        return learnRecordService.getLearnRecord(phoneNum, type);
    }
}
