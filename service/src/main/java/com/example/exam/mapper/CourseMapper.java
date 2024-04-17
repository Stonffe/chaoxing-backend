package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.entity.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname: CourseMapper
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/17 22:32
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
