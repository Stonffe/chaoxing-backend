package com.example.exam.controller;

import com.example.exam.dto.LoginDto;
import com.example.exam.dto.RegisterDto;
import com.example.exam.entity.User;
import com.example.exam.resp.RestResp;
import com.example.exam.service.UserService;
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
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public RestResp<Map<String,String>> login(@RequestBody LoginDto loginDto) {
        log.info("{}",loginDto);
        return userService.login(loginDto);
    }
    @PostMapping("/register")
    public RestResp<Void> register(@RequestBody RegisterDto registerDto) {
        return userService.register(registerDto);
    }
    @PostMapping("/modifyPassword")
    public RestResp<Void> modifyPassword(@RequestBody LoginDto loginDto) {
        return userService.modifyPassword(loginDto);
    }
}
