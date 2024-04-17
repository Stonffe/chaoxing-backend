package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.dto.LoginDto;
import com.example.exam.dto.RegisterDto;
import com.example.exam.entity.User;
import com.example.exam.resp.RestResp;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Classname: TeacherService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/16 14:16
 */
@Service
public interface UserService extends IService<User> {
    /**
     * 登录
     * @param loginDto
     * @return
     */
    RestResp<Map<String,String>> login(LoginDto loginDto);

    /**
     * 注册用户
     * @param registerDto
     * @return
     */
    RestResp<Void> register(RegisterDto registerDto);

    /**
     * 修改密码
     * @param loginDto
     * @return
     */
    RestResp<Void> modifyPassword(LoginDto loginDto);
}
