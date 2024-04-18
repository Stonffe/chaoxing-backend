package com.example.exam.controller;

import com.example.exam.entity.Course;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname: CourseController
 * @Author: Stonffe
 * @Date: 2024/4/17 23:48
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Operation(summary = "查询已创建课程列表")
    @GetMapping("/getCreateClass/{phoneNum}")
    public RestResp<List<Course>> getCreateClass(@PathVariable String phoneNum) {
        return courseService.getCreateClass(phoneNum);
    }

}
