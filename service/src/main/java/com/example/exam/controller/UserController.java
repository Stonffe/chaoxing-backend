package com.example.exam.controller;

import com.example.exam.dto.LoginDto;
import com.example.exam.dto.RegisterDto;
import com.example.exam.entity.User;
import com.example.exam.resp.RestResp;
import com.example.exam.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: UserController
 * @Author: Stonffe
 * @Date: 2024/4/17 18:40
 */
@Tag(name = "UserController", description = "用户操作模块")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "用户登录接口")
    @PostMapping("/login")
    public RestResp<Map<String,String>> login(@RequestBody LoginDto loginDto) {
        log.info("{}",loginDto);
        return userService.login(loginDto);
    }

    @Operation(summary = "用户注册接口")
    @PostMapping("/register")
    public RestResp<Void> register(@RequestBody RegisterDto registerDto) {
        return userService.register(registerDto);
    }

    @Operation(summary = "修改密码接口")
    @PostMapping("/modifyPassword")
    public RestResp<Void> modifyPassword(@RequestBody LoginDto loginDto) {
        return userService.modifyPassword(loginDto);
    }
}
