package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.JoinClassDto;
import com.example.exam.entity.Course;
import com.example.exam.mapper.CourseMapper;
import com.example.exam.resp.RestResp;
import com.example.exam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: CourseServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/17 22:34
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public RestResp<List<Course>> getClass(String phoneNum, int role) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", phoneNum);
        wrapper.eq("role", role);
        List<Course> list = courseMapper.selectList(wrapper);
        return RestResp.ok(list);
    }

    @Override
    public RestResp<Void> joinClass(JoinClassDto joinClassDto) {
//        courseMapper.insert()
        return RestResp.ok();
    }
}
