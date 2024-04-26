package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.entity.CourseList;
import com.example.exam.resp.RestResp;

import java.util.List;

/**
 * @Classname: CourseListService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/18 19:48
 */
public interface CourseListService extends IService<CourseList> {
    /**
     * 课时列表
     *
     * @param courseId
     * @return
     */
    RestResp<List<CourseList>> getCourseList(Integer courseId);
}
