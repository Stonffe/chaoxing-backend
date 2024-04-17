package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname: StudentMapper
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/16 14:20
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
