package com.example.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.entity.Student;
import com.example.exam.mapper.StudentMapper;
import com.example.exam.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Classname: StudentServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/16 14:18
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

}
