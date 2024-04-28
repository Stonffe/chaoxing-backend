package com.example.exam.controller;

import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.entity.SelectedCourses;
import com.example.exam.entity.User;
import com.example.exam.resp.RestResp;
import com.example.exam.service.SelectedCoursesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname: SelectedCoursesController
 * @Author: Stonffe
 * @Date: 2024/4/18 16:13
 */
@Tag(name = "SelectedCoursesController", description = "已选课程控制器")
@RestController
public class SelectedCoursesController {
    @Autowired
    private SelectedCoursesService service;

    @Operation(summary = "加入课程接口")
    @PostMapping("/joinClass")
    public RestResp<Void> joinClass(@RequestBody JoinClassDto joinClassDto) {
        return service.joinClass(joinClassDto);
    }

    @Operation(summary = "查看已选课程接口")
    @GetMapping("/getJoinClass/{phoneNum}")
    public RestResp<List<Course>> getJoinClass(@PathVariable String phoneNum) {
        return service.getJoinClass(phoneNum);
    }

    @Operation(summary = "根据课程id查询选课学生")
    @GetMapping("getUserByCourseId/{courseId}")
    public RestResp<List<User>> getUserByCourseId(@PathVariable Integer courseId) {
        return service.getUserByCourseId(courseId);
    }
}
