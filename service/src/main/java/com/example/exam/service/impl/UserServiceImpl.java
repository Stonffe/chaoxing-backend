package com.example.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exam.dto.LoginDto;
import com.example.exam.dto.RegisterDto;
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
 * @Classname: UserServiceImpl
 * @Author: Stonffe
 * @Date: 2024/4/16 14:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param loginDto
     * @return
     */
    @Override
    public RestResp<Map<String, String>> login(LoginDto loginDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", loginDto.getPhoneNum());
        // 根据手机号查询用户信息
        User user = userMapper.selectOne(wrapper);
        // 差不多用户
        if (Objects.isNull(user)) {
            throw new BusinessException(ErrorCodeEnum.USER_NOT_EXIST);
        }
        // 密码不正确
        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new BusinessException(ErrorCodeEnum.PASSWORD_ERROR);
        }
        // 作为返回数据
        HashMap<String, String> map = new HashMap<>();
        // 用于生成jwt
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("phoneNum", user.getPhoneNum());
        String jwt = JwtUtils.generateJwt(map1);
        map.put("jwt", jwt);
        map.put("username", user.getUsername());
        System.out.println(RestResp.ok(map));
        return RestResp.ok(map);
    }

    /**
     * 注册用户
     *
     * @param registerDto
     * @return
     */
    @Override
    public RestResp<Void> register(RegisterDto registerDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phoneNum", registerDto.getPhoneNum());
        // 判断此电话是否已经被注册
        if (userMapper.selectCount(wrapper) > 0) {
            throw new BusinessException(ErrorCodeEnum.USER_EXISTS);
        }
        // 插入用户注册信息到数据库
        User user = new User();
        user.setPassword(registerDto.getPassword());
        user.setUsername(registerDto.getUsername());
        user.setPhoneNum(registerDto.getPhoneNum());
        userMapper.insert(user);
        return RestResp.ok();
    }

    /**
     * 修改密码
     *
     * @param loginDto
     * @return
     */
    @Override
    public RestResp<Void> modifyPassword(LoginDto loginDto) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("phoneNum", loginDto.getPhoneNum());
        wrapper.set("password", loginDto.getPassword());
        userMapper.update(null, wrapper);
        return RestResp.ok();
    }
}
