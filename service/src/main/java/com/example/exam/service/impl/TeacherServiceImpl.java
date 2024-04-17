package com.example.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.Teacher;
import com.example.exam.mapper.TeacherMapper;
import com.example.exam.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @Classname: TeacherServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/16 14:50
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
