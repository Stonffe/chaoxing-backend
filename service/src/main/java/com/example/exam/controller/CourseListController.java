package com.example.exam.controller;

import com.example.exam.entity.CourseList;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseListService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if (courseList.getTitle() == null || courseList.getTitle().length() == 0) return RestResp.fail("500", "未输入");
        courseListService.save(courseList);
        return RestResp.ok();
    }

    @Operation(summary = "课时列表")
    @GetMapping("getCourseList/{courseId}")
    public RestResp<List<CourseList>> getCourseList(@PathVariable Integer courseId) {
        return courseListService.getCourseList(courseId);
    }

    @Operation(summary = "删除课时")
    @DeleteMapping("deleteCourseList/{courseListId}")
    public RestResp<Void> deleteCourseList(@PathVariable Integer courseListId) {
        courseListService.removeById(courseListId);
        return RestResp.ok();
    }
}
