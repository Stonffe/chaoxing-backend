package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.LoginDto;
import com.example.exam.entity.User;
import com.example.exam.execption.BusinessException;
import com.example.exam.mapper.UserMapper;
import com.example.exam.resp.ErrorCodeEnum;
import com.example.exam.resp.RestResp;
import com.example.exam.service.UserService;
import com.example.exam.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Classname: TeacherServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/16 14:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public RestResp<Map<String,String>> login(LoginDto loginDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum",loginDto);
        User user = userMapper.selectOne(wrapper);
        if (Objects.isNull(user)) {
            throw new BusinessException(ErrorCodeEnum.USER_NOT_EXIST);
        }
        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new BusinessException(ErrorCodeEnum.PASSWORD_ERROR);
        }
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("phoneNum",user.getPhoneNum());
        String jwt = JwtUtils.generateJwt(map1);
        map.put("jwt",jwt);
        map.put("url",user.getUrl());
        map.put("username",user.getUsername());
        return RestResp.ok(map);
    }
}
