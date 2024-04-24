package com.example.exam.controller;

import com.example.exam.entity.CourseList;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseListService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: CourseListController
 * @Author: Stonffe
 * @Date: 2024/4/18 19:54
 */
@RestController
public class CourseListController {
    @Autowired
    private CourseListService courseListService;

    @Operation(summary = "添加课时")
    @PostMapping("addCourseList")
    public RestResp<Void> addCourseList(@RequestBody CourseList courseList) {
        courseListService.save(courseList);
        return RestResp.ok();
    }
}