package com.example.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname: TeacherMapper
 * @Author: Stonffe
 * @Date: 2024/4/16 14:21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
