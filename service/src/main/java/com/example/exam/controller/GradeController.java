package com.example.exam.controller;

import com.example.exam.resp.RestResp;
import com.example.exam.service.GradeService;
import com.example.exam.vo.GradeVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname: GradeController
 * @Author: Stonffe
 * @Date: 2024/4/27 23:49
 */
@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @Operation(summary = "添加成绩")
    @GetMapping("insertGrade/{phoneNum}/{courseId}")
    public RestResp<Void> insertGrade(@PathVariable String phoneNum, @PathVariable Integer courseId) {
        return gradeService.insertGrade(phoneNum, courseId);
    }

    @Operation(summary = "查询成绩")
    @GetMapping("selectGrade/{phoneNum}/{courseId}")
    public RestResp<GradeVo> selectGrade(@PathVariable String phoneNum, @PathVariable Integer courseId) {
        return gradeService.selectGrade(phoneNum, courseId);
    }

    @Operation(summary = "查询所有成绩")
    @GetMapping("selectGrade/{courseId}")
    public RestResp<List<GradeVo>> selectAllGrade(@PathVariable Integer courseId) {
        return gradeService.selectAllGrade(courseId);
    }
}
