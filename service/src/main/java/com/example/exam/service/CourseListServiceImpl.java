package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.CourseList;
import com.example.exam.mapper.CourseListMapper;
import org.springframework.stereotype.Service;

/**
 * @Classname: CourseListServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/18 19:48
 */
@Service
public class CourseListServiceImpl extends ServiceImpl<CourseListMapper, CourseList> implements CourseListService {
}
