package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname: QuestionMapper
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/18 19:22
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
}
