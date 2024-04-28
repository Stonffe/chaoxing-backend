package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname: GradeMapper
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/27 23:42
 */
@Mapper
public interface GradeMapper extends BaseMapper<Grade> {
}
