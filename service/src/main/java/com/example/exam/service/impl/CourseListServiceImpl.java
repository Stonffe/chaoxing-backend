package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.CourseList;
import com.example.exam.mapper.CourseListMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: CourseListServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/18 19:48
 */
@Service
public class CourseListServiceImpl extends ServiceImpl<CourseListMapper, CourseList> implements CourseListService {
    @Autowired
    private CourseListMapper courseListMapper;

    /**
     * 课时列表
     *
     * @param courseId
     * @return
     */
    @Override
    public RestResp<List<CourseList>> getCourseList(Integer courseId) {
        QueryWrapper<CourseList> wrapper = new QueryWrapper<>();
        wrapper.eq("courseId", courseId);
        List<CourseList> list = courseListMapper.selectList(wrapper);
        return RestResp.ok(list);
    }
}
