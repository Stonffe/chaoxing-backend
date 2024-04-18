package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.resp.RestResp;

import java.util.List;

/**
 * @Classname: CourseService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/17 22:32
 */
public interface CourseService extends IService<Course> {

    /**
     * 查询课程列表
     *
     * @param phoneNum
     * @return
     */
    RestResp<List<Course>> getCreateClass(String phoneNum);
}
